package com.Wilderness.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.WildernessDBConfig;

public class User extends Employee {
	
	private String email;
	private String password;
	
	public User(String employeeId, String employeeNum,String firstName, String lastName, String dateStarted, String email, String password) {
		super(employeeId,employeeNum,firstName, lastName,dateStarted);
		this.email = email;
		this.password = password;
		
	}
	public User(String employeeNum, String email, String password) {
		employeeNum = super.employeeNum;
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
	public boolean validRegister(String employeeNum, String email, String password) {
		PreparedStatement isUnique;
		//PreparedStatement empNum;
		ResultSet rs1;
		PreparedStatement registerUser;
		//ResultSet rs2;
		try {
			isUnique = WildernessDBConfig.getConnection().prepareStatement("select x.employee, y.user from (select employee_num from employee where employee_num = ?) as x, (select * from user where email = ? and password = ?) as y");//select * from user where email = ? and password = ?
			//empNum = WildernessDBConfig.getConnection().prepareStatement("select employee_num from employee where employee_num = ?");
			registerUser = WildernessDBConfig.getConnection().prepareStatement("insert into user (emp_num, email, password) values (?,?,?)");
			registerUser.setString(1, employeeNum);
			registerUser.setString(2, email);
			registerUser.setString(3, password);
			isUnique.setString(1, employeeNum);
			isUnique.setString(2, email);
			isUnique.setString(3, password);
			//empNum.setString(1, employeeNum);
			rs1 = isUnique.executeQuery();
			//rs2 = empNum.executeQuery();
			if(!rs1.next()) {
				registerUser.executeUpdate();
				return true;
			}
			else {
				return false;
			}

		}
		catch(Exception a) {
			a.printStackTrace();
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