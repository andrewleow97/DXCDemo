package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginEmployee;
import com.mvc.dao.LoginDAO;

public class RegisterServlet extends HttpServlet {
	public RegisterServlet() {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		LoginEmployee employee = new LoginEmployee();
		
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setRole(role);
		
		LoginDAO LoginDao = new LoginDAO();
		
		try {
			String userRegistered = LoginDao.registerUser(employee);
			if (userRegistered.equals("Success")) { // employee page
				request.setAttribute("msg", "User successfully registered.");
				request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			} else { // invalid login
				request.setAttribute("errMessage", userRegistered);
				request.getRequestDispatcher("/JSP/Register.jsp").forward(request, response);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
