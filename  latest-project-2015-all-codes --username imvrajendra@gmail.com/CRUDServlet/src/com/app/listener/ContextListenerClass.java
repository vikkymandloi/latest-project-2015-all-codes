package com.app.listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.connection.OracleConnection;

public class ContextListenerClass implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Servlet Context Listener Initialized..!");
		Connection connection = null;
		ServletContext context = event.getServletContext();
		try {
			connection = OracleConnection.getConnection();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		context.setAttribute("connection", connection);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Servlet Context Listener Destroyed..!");
		ServletContext context = event.getServletContext();
		context.removeAttribute("connection");
		System.out.println("Attribute removed..!");
	}
}
