package by.rudzko.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.rudzko.web.controller.command.Command;

public class FrontController extends HttpServlet {
	private static final String USER_JSP = "/WEB-INF/jsp/user.jsp";
	private static final String COMMAND = "command";
	private static final long serialVersionUID = 1L;
    
    public FrontController() {
        super();
    }

		public void init(ServletConfig config) throws ServletException {
//	try {
//			Statement statement = ConnectionCreator.getConnection().createStatement();
//			statement.executeUpdate(String.format(Locale.ENGLISH,"CREATE DATABASE olgarudzko;"));
//			statement.executeUpdate(String.format(Locale.ENGLISH,"CREATE TABLE mysql.Profiles ( ID INT NOT NULL AUTO_INCREMENT, Name VARCHAR(30) " +
//		            "NOT NULL , Surname VARCHAR(30) NOT NULL, Phone INT(15) NOT NULL , Email VARCHAR(30) NOT NULL, PRIMARY KEY (ID))"));
//			int phone=9920982;
//			statement.executeUpdate(String.format(Locale.ENGLISH, "insert into Profiles (Name, Surname, Phone, Email) values('%s', '%s', '%d', '%s');", "Olga", "Rudzko", phone, "leta.rudzko@gmail.com"));
//			} catch (SQLException e) {
//				e.printStackTrace();
//		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strCommand = request.getParameter(COMMAND);
		Command command = CommandProvider.getCommand(strCommand);
		command.execute(request, response);
		RequestDispatcher disp = request.getRequestDispatcher(USER_JSP);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
