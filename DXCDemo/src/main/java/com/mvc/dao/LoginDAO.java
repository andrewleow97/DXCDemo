package com.mvc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.mvc.JDBC.JDBConnection;
import com.mvc.bean.LoginEmployee;

public class LoginDAO {

	public String authenticateUser(LoginEmployee employee) {
		String username = employee.getUsername();
		String password = employee.getPassword();
		
		String DBuser = "";
		String DBpw = "";
		String DBrole = "";
		
		Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
		
		try {
			con = JDBConnection.createConnection();
			// prevent sql injection
			statement = con.prepareStatement("select username, password, role from employees where username = ? and password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			
			if (resultSet.next() == false) { // checking if user/pw exists in db
				return "Invalid user credentials";
			}
			
			DBuser = resultSet.getString("username");
			DBpw = resultSet.getString("password");
			DBrole = resultSet.getString("role");
			
			if (DBrole.equals("Employee")) {
				con.close();
				return "Employee";
			}
				
			else if (DBrole.equals("Manager")) {
				con.close();
				return "Manager";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Invalid user credentials";
	}
	
	public String registerUser(LoginEmployee employee) {
		String username = employee.getUsername();
		String password = employee.getPassword();
		String role = employee.getRole();
		
		
		Connection con = null;
        PreparedStatement statement = null;
		
		try {
			con = JDBConnection.createConnection();
			PreparedStatement checkstatement = con.prepareStatement("select * from employees where username=? and password=?"); // checking for duplicates
			checkstatement.setString(1, username);
			checkstatement.setString(2, password);
			ResultSet resultSet = checkstatement.executeQuery();
			if (resultSet.next()) {
				return "Username and password already in use";
			}
			
			// prevent sql injection
			statement = con.prepareStatement("insert into employees values (?, ?, ?);");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, role);
			int i = statement.executeUpdate();
			
			if (i != 0) { 
				con.close();
				return "Success";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Insertion failed.";
	}
}
