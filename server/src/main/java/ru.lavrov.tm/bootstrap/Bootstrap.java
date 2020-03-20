package ru.lavrov.tm.bootstrap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.persistence.sessions.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reflections.Reflections;
import ru.lavrov.tm.endpoint.SessionEndpoint;
import ru.lavrov.tm.endpoint.TestEndpoint;
import ru.lavrov.tm.endpoint.UserEndpoint;
import ru.lavrov.tm.entity.User;
import ru.lavrov.tm.enumerate.Role;
import ru.lavrov.tm.exception.command.CommandDescriptionIsInvalidException;
import ru.lavrov.tm.exception.command.CommandIsInvalidException;
import ru.lavrov.tm.exception.command.CommandNotExistsException;
import ru.lavrov.tm.exception.util.UtilAlgorithmNotExistsException;
import ru.lavrov.tm.repository.ProjectRepositoryImpl;
import ru.lavrov.tm.repository.TaskRepositoryImpl;
import ru.lavrov.tm.repository.UserRepositoryImpl;
import ru.lavrov.tm.api.*;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.exception.user.*;
import ru.lavrov.tm.service.ProjectServiceImpl;
import ru.lavrov.tm.service.SessionService;
import ru.lavrov.tm.service.TaskServiceImpl;
import ru.lavrov.tm.service.UserServiceImpl;
import ru.lavrov.tm.util.HashUtil;
import ru.lavrov.tm.util.InputUtil;

import javax.xml.ws.Endpoint;
import java.util.*;

@Getter
@NoArgsConstructor
public final class Bootstrap implements IServiceLocator {
    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepositoryImpl();
    @NotNull
    private final ITaskRepository taskRepository = new TaskRepositoryImpl();
    @NotNull
    private final IUserRepository userRepository = new UserRepositoryImpl();
    @NotNull
    private final IProjectService projectService =
            new ProjectServiceImpl(projectRepository, taskRepository, userRepository);
    @NotNull
    private final ITaskService taskService = new TaskServiceImpl(taskRepository, projectRepository, userRepository);
    @NotNull
    private final IUserService userService = new UserServiceImpl(userRepository, projectRepository, taskRepository);
    @NotNull
    private final ISessionService sessionService = new SessionService(userRepository);
    @NotNull
    private final Map<String, AbstractCommand> commands = new LinkedHashMap();
    @Nullable
    private static final Set<Class<? extends AbstractCommand>> classes;
    @NotNull
    private final TestEndpoint testEndpoint = new TestEndpoint();
    @NotNull
    private final UserEndpoint userEndpoint = new UserEndpoint();
    @NotNull
    private final SessionEndpoint sessionEndpoint = new SessionEndpoint(this);
    @Setter
    @Nullable
    private User currentUser;

    static {
        classes = new Reflections("ru.lavrov.tm").getSubTypesOf(AbstractCommand.class);
    }

    public void init() throws InstantiationException, IllegalAccessException {
        initProperties();
        initClasses(classes);
        initUsers();
        initEndpoints();
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        @Nullable String command = null;

        while (!"exit".equals(command)) {
            command = InputUtil.INPUT.nextLine();
            try {
                execute(command);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initEndpoints(){
        Endpoint.publish(TestEndpoint.URL, testEndpoint);
        Endpoint.publish(UserEndpoint.URL, userEndpoint);
        Endpoint.publish(SessionEndpoint.URL, sessionEndpoint);
    }

    private void initClasses(
            @Nullable Collection<Class<? extends AbstractCommand>> classes
    ) throws IllegalAccessException, InstantiationException {
        if (classes == null || classes.isEmpty())
            return;
        for (@Nullable Class command : classes) {
            if (command == null)
                continue;
            if (!AbstractCommand.class.isAssignableFrom(command))
                continue;
            registry((AbstractCommand) command.newInstance());
        }
    }

    private void initUsers() {
        userService.createByLogin("user", "user", Role.USER.getRole());
        userService.createByLogin("admin", "admin", Role.ADMIN.getRole());
    }

    private void initProperties(){
        System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
    }

    private void registry(@Nullable final AbstractCommand command) {
        if (command == null)
            throw new CommandNotExistsException();
        @Nullable final String cliCommand = command.getCommand();
        @Nullable final String cliDescription = command.getDescription();
        if (cliCommand == null || cliCommand.isEmpty())
            throw new CommandIsInvalidException();
        if (cliDescription == null || cliDescription.isEmpty())
            throw new CommandDescriptionIsInvalidException();
        command.setBootstrap(this);
        commands.put(cliCommand, command);
    }

    private void execute(@Nullable final String command) {
        if (command == null || command.isEmpty())
            throw new CommandIsInvalidException();
        @Nullable final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null)
            throw new CommandNotExistsException();
        if (currentUser == null && !abstractCommand.isSafe())
            throw new UserIsNotAuthorizedException();
        @Nullable Role role;
        if (currentUser == null)
            role = null;
        else
            role = currentUser.getRole();
        if (!hasPermission(abstractCommand.getRoles(), role))
            throw new UserDoNotHavePermissionException();
        abstractCommand.execute();
    }

    private boolean hasPermission(@Nullable final Collection<Role> listRoles, @Nullable Role role) {
        if (listRoles == null)
            return true;
        if (role == null)
            throw new UserRoleIsInvalidException();
        return listRoles.contains(role);
    }

    @Nullable
    public List<AbstractCommand> getCommands() {
        return new ArrayList(commands.values());
    }

//    public void login(@Nullable final String login, @Nullable final String password) {
//        if (login == null || login.isEmpty())
//            throw new UserLoginIsInvalidException();
//        if (password == null || password.isEmpty())
//            throw new UserPasswordIsInvalidException();
//        @Nullable final User user = userRepository.findUserByLogin(login);
//        if (user == null)
//            throw new UserLoginNotExistsException();
//        @Nullable String hashedPassword;
//            hashedPassword = HashUtil.md5Hard(password);
//        if (!hashedPassword.equals(user.getPassword()))
//            throw new UserLoginOrPasswordIsIncorrectException();
//        setCurrentUser(user);
//    }

    public void logout() {
        setCurrentUser(null);
    }
}