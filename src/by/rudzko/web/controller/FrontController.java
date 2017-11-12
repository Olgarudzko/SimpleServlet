package by.rudzko.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.rudzko.web.controller.command.Command;
import by.rudzko.web.domain.entity.User;
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

		public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strCommand = request.getParameter("command");
		Command command = CommandProvider.getCommand(strCommand);
		command.execute(request, response);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
