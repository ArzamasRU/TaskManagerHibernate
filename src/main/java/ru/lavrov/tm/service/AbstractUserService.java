//package ru.lavrov.tm.service;
//
//import ru.lavrov.tm.api.IUserRepository;
//import ru.lavrov.tm.api.IUserService;
//import ru.lavrov.tm.entity.User;
//import ru.lavrov.tm.exception.user.UserIsNotAuthorizedException;
//import ru.lavrov.tm.exception.user.UserNotExistsException;
//
//import java.util.Collection;
//
//public abstract class AbstractUserService implements IUserService<User> {
//    protected final IUserRepository userRepository;
//
//    protected AbstractUserService(final IUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void persist(final User user) {
//        if (user == null)
//            throw new UserNotExistsException();
//        userRepository.persist(user);
//    }
//
//    @Override
//    public void merge(final User user) {
//        if (user == null)
//            throw new UserNotExistsException();
//        userRepository.merge(user);
//    }
//
//    @Override
//    public void remove(final String entityId, final String userId) {
//        if (entityId == null || entityId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        userRepository.remove(entityId, userId);
//    }
//
//    @Override
//    public void removeAll(final String userId) {
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        userRepository.removeAll(userId);
//    }
//
//    @Override
//    public Collection<User> findAll(final String userId) {
//        if (userId == null || userId.isEmpty())
//            throw new UserIsNotAuthorizedException();
//        return userRepository.findAll(userId);
//    }
//}
