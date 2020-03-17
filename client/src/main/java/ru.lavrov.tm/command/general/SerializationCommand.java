package ru.lavrov.tm.command.general;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.api.IProjectService;
import ru.lavrov.tm.api.ITaskService;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.constant.Constant;
import ru.lavrov.tm.entity.Project;
import ru.lavrov.tm.entity.Task;
import ru.lavrov.tm.entity.User;
import ru.lavrov.tm.enumerate.Role;
import ru.lavrov.tm.exception.user.UserIsNotAuthorizedException;
import ru.lavrov.tm.util.SerializationUtil;

import java.util.Arrays;
import java.util.Collection;

public final class SerializationCommand extends AbstractCommand {
    private static final boolean SAFE = true;
    @Nullable
    private static final Collection<Role> ROLES = Arrays.asList(Role.ADMIN, Role.USER);
    @NotNull
    private static final String COMMAND = "serialize";
    @NotNull
    private static final String DESCRIPTION = "Serialize data.";

    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute() {
        System.out.println("[Serialize data]");
        @Nullable final User currentUser = bootstrap.getCurrentUser();
        if (currentUser == null)
            throw new UserIsNotAuthorizedException();
        SerializationUtil.write(Arrays.asList(currentUser), Constant.USERS_FILE_PATH);
        @NotNull final IProjectService projectService = bootstrap.getProjectService();
        @NotNull final Collection<Project> projectList = projectService.findAll(currentUser.getId());
        SerializationUtil.write(projectList, Constant.PROJECTS_FILE_PATH);
        @Nullable final ITaskService taskService = bootstrap.getTaskService();
        @Nullable final Collection<Task> taskList = taskService.findAll(currentUser.getId());
        SerializationUtil.write(taskList, Constant.TASKS_FILE_PATH);
        System.out.println("[ok]");
        System.out.println();
    }

    @Override
    public boolean isSafe() {
        return SAFE;
    }

    @Nullable
    @Override
    public Collection<Role> getRoles() {
        return ROLES;
    }
}
