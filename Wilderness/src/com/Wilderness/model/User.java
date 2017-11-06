package com.Wilderness.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.WildernessDBConfig;

public class User extends Employee {
	
	private String email;
	private String password;
	
	public User(String userId, String employeeNum,String firstName, String lastName, String dateStarted, String email, String password) {
		super(userId,employeeNum,firstName, lastName,dateStarted);
		this.email = email;
		this.password = password;
		
	}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public boolean validLogin(String email, String password) {
		PreparedStatement ps;
		ResultSet resultSet;
		try {
			ps = WildernessDBConfig.getConnection().prepareStatement("select * from user where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			 resultSet = ps.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
