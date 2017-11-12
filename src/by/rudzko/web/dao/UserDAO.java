package by.rudzko.web.dao;

import by.rudzko.web.dao.exception.DAOException;
import by.rudzko.web.domain.entity.User;

public interface UserDAO {

	User findUser(User user) throws DAOException;
}
