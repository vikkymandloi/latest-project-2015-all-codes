package com.app.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.EntryValue;
import com.pojo.UserPojo;
import com.queryDb.WelcomeQuery;

public class WelcomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionAtt = request.getParameter("actionSubmit");
		
		if(request.getMethod().equals("POST") && ("update".equals(actionAtt) || "delete".equals(actionAtt))) {
			doPost(request, response);
		} else{
			HttpSession session = request.getSession();
			rd = getServletContext().getRequestDispatcher(response.encodeRedirectURL("/Welcome.jsp"));
			Connection  connection = (Connection) getServletContext().getAttribute("connection");
			UserPojo user = new UserPojo();
			user.setUsername((String)session.getAttribute("username"));
			String loadText = WelcomeQuery.welcomeLoad(connection, user);
			if(loadText!=null) {
				request.setAttribute("LOAD_TEXT", loadText);
			}
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post Method Called only when Submitted form.");
		String actionAtt = request.getParameter("actionSubmit");
		
		HttpSession session = request.getSession();
		rd = getServletContext().getRequestDispatcher(response.encodeRedirectURL("/Welcome.jsp"));
		Connection  connection = (Connection) getServletContext().getAttribute("connection");
		EntryValue entry = new EntryValue();
		entry.setUsername((String)session.getAttribute("username"));
		if("update".equals(actionAtt)) {
			entry.setEntryvalue(request.getParameter("LoadTextArea"));
		} 
		if("delete".equals(actionAtt)) {
			entry.setEntryvalue(null);
		}
		boolean status = WelcomeQuery.welcomeUpdate(connection, entry);
		if(status) {
			request.setAttribute("LOAD_TEXT",entry.getEntryvalue());
		}
		rd.forward(request, response);
	}

}
