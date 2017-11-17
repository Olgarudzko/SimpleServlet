package by.rudzko.web.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.rudzko.web.dao.ConnectionCreator;
import by.rudzko.web.dao.UserDAO;
import by.rudzko.web.dao.exception.DAOException;
import by.rudzko.web.domain.entity.User;

public class UserDAOimpl implements UserDAO{

	private static final String USER_REQUEST = "SELECT * FROM Profiles WHERE Name='%s' and Surname='%s'";
	private static final String EMAIL = "Email";
	private static final String PHONE = "Phone";

	@Override
	public User findUser(User user) throws DAOException {
		try {
			Statement statement = ConnectionCreator.getConnection().createStatement();
			ResultSet fullInfo = statement.executeQuery(String.format(USER_REQUEST, user.getName(), user.getSurname()));
			fullInfo.next();
			user.setPhone(fullInfo.getInt(PHONE));
			user.setEmail(fullInfo.getString(EMAIL));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
