package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.UserPojo;
import com.queryDb.LoginQuery;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserPojo user = new UserPojo();
		user.setUsername(username);
		user.setPassword(password);
		
		Connection  connection = (Connection) getServletContext().getAttribute("connection");
		System.out.println(connection);
		RequestDispatcher rd = null;
		boolean loginSuccess = LoginQuery.loginValidate(connection, user);
		if(loginSuccess) {
			session.setAttribute("username", user.getUsername());
			rd = request.getRequestDispatcher("/welcome");
			rd.forward(request, response);
		} else {
			session.invalidate();
            request.setAttribute("errorMessage", "Invalid user or password..!");
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response); 
		}
	}

	public void init() throws ServletException {
		System.out.println("Login Controller Initialized..!");
	}
}
