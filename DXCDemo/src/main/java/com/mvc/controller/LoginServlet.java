package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginEmployee;
import com.mvc.dao.LoginDAO;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginEmployee employee = new LoginEmployee();
		
		employee.setUsername(username);
		employee.setPassword(password);
		
		LoginDAO LoginDao = new LoginDAO();
		
		try {
			String userValidate = LoginDao.authenticateUser(employee);
			if (userValidate.equals("Employee")) { // employee page
				HttpSession session = request.getSession();
				session.setAttribute("Employee", userValidate);
				request.setAttribute("username", employee.getUsername());
				request.setAttribute("role", userValidate);
				request.getRequestDispatcher("/JSP/Employee.jsp").forward(request, response);
			} else if (userValidate.equals("Manager")) { // manager page
				HttpSession session = request.getSession();
				session.setAttribute("Manager", userValidate);
				request.setAttribute("username", employee.getUsername());
				request.setAttribute("role", userValidate);
				request.getRequestDispatcher("/JSP/Manager.jsp").forward(request, response);
			} else { // invalid login
				request.setAttribute("errorMessage", userValidate);
				request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
