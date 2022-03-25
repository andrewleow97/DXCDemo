package com.mvc.controller;
 
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class LogoutServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
     HttpSession session = request.getSession(false); //Fetch session object
 
        if(session!=null) // if there is session
         {
             session.invalidate(); 
             request.setAttribute("errMessage", "You have logged out successfully"); // close and return to login page
             request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
             System.out.println("Logged out");
             
         }
    }
}