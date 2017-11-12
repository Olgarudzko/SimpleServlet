package by.rudzko.web.service;

import by.rudzko.web.service.implementation.UserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
