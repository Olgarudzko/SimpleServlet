package by.rudzko.web.service.implementation;

import by.rudzko.web.dao.DAOFactory;
import by.rudzko.web.dao.UserDAO;
import by.rudzko.web.dao.exception.DAOException;
import by.rudzko.web.domain.entity.User;
import by.rudzko.web.service.UserService;
import by.rudzko.web.service.exception.ServiceException;

public class UserServiceImpl implements UserService{

	@Override
	public User findUser(User user) throws ServiceException {

		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
        try {
			return userDAO.findUser(user);
		} catch (DAOException e) {
			throw new ServiceException (e)	;
		}	
     }
}
