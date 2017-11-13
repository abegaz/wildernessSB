package com.Wilderness.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.WildernessDBConfig;

public class Employee {
	protected String employeeId;
	protected String employeeNum;
	protected String firstName;
	protected String lastName;
	protected String dateStarted;
	
	public Employee(String employeeId, String employeeNum, String firstName, String lastName, String dateStarted) {
		super();
		this.employeeId = employeeId;
		this.employeeNum = employeeNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateStarted = dateStarted;
	}
	public Employee(String employeeId, String employeeNum) {
		this.employeeId = employeeId;
		this.employeeNum = employeeNum;
	}
	public Employee(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	public Employee() {
		
	}
	public static boolean isUniqueEmpNum(String employeeNum) {
		PreparedStatement empNum;
		PreparedStatement empNumUser;
		PreparedStatement insertEmpNum;
		PreparedStatement insertEmpNum2; //Adding non existant Emp num
		ResultSet rs;
		ResultSet rs2;
		try {
			empNum = WildernessDBConfig.getConnection().prepareStatement("select employee_num from employee where employee_num = ?");
			empNumUser = WildernessDBConfig.getConnection().prepareStatement("select emp_num from user where emp_num = ?");
			insertEmpNum = WildernessDBConfig.getConnection().prepareStatement("INSERT INTO user (emp_num) SELECT employee_num FROM employee where employee_num = ?");
			empNumUser.setString(1, employeeNum);
			insertEmpNum.setString(1, employeeNum);
			empNum.setString(1, employeeNum);
			rs = empNum.executeQuery();
			rs2 = empNumUser.executeQuery();
		if(!rs2.next()&&rs.next()) {
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
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDate_started() {
		return dateStarted;
	}

	public void setDate_started(String date_started) {
		this.dateStarted = date_started;
	}

}
