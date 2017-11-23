package by.rudzko.web.controller.command.implementation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.rudzko.web.controller.command.Command;
import by.rudzko.web.domain.entity.User;
import by.rudzko.web.service.ServiceFactory;
import by.rudzko.web.service.exception.ServiceException;

public class FindUserCommand implements Command{

	private static final String USER2 = "user";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		user.setName(request.getParameter(NAME));
		user.setSurname(request.getParameter(SURNAME));
		ServiceFactory factory = ServiceFactory.getInstance();
		
		try {
			user=factory.getUserService().findUser(user);
		} catch (ServiceException e) {
			user=null;
			e.printStackTrace();
		}
		request.setAttribute(USER2, user);// в случае исключительной ситвации ты передаешь на страницу jsp
		// явно и сама null парамерт - зачем?
		// у тебя же ошибка произошла
	}

}
