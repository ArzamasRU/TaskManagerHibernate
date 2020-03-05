//package ru.lavrov.tm.service;
//
//import ru.lavrov.tm.api.IProjectService;
//import ru.lavrov.tm.api.ITaskRepository;
//import ru.lavrov.tm.api.IUserRepository;
//import ru.lavrov.tm.entity.Project;
//import ru.lavrov.tm.exception.project.ProjectNotExistsException;
//import ru.lavrov.tm.exception.user.UserIsNotAuthorizedException;
//import ru.lavrov.tm.repository.AbstractProjectRepository;
//
//import java.util.Collection;
//
//public abstract class AbstractProjectService implements IProjectService<Project> {
//    protected final AbstractProjectRepository projectRepository;
//    protected final ITaskRepository taskRepository;
//    protected final IUserRepository userRepository;
//
//    public AbstractProjectService(final AbstractProjectRepository projectRepository, final ITaskRepository taskRepository,
//                                  final IUserRepository userRepository) {
//        this.projectRepository = projectRepository;
//        this.taskRepository = taskRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void persist(final Project project) throws RuntimeException {
//        if (project == null)
//            throw new ProjectNotExistsException();
//        projectRepository.persist(project);
//    }
//
//    @Override
//    public void merge(final Project project) {
//        if (project == null)
//            throw new ProjectNotExistsException();
//        projectRepository.persist(project);
//    }
//
//    @Override
//    public void remove(final String projectId, final String userId) {
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        if (projectId == null || projectId.isEmpty())
//            throw new ProjectNotExistsException();
//        projectRepository.remove(projectId, userId);
//    }
//
//    @Override
//    public void removeAll(final String userId) {
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        projectRepository.removeAll(userId);
//    }
//
//    @Override
//    public Collection<Project> findAll(final String userId){
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        return projectRepository.findAll(userId);
//    }
//}
