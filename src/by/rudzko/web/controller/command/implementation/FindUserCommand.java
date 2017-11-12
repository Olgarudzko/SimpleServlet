package by.rudzko.web.controller.command.implementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.rudzko.web.controller.command.Command;
import by.rudzko.web.domain.entity.User;
import by.rudzko.web.service.ServiceFactory;
import by.rudzko.web.service.exception.ServiceException;

public class FindUserCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		ServiceFactory factory = ServiceFactory.getInstance();
		try {
			factory.getUserService().findUser(user);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO request to some database for filling user data
		
		request.setAttribute("user", user);
	}

}
