package by.rudzko.web.service;

import by.rudzko.web.domain.entity.User;
import by.rudzko.web.service.exception.ServiceException;

public interface UserService {
		User findUser(User user) throws ServiceException;
}
