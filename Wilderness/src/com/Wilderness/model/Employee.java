package com.Wilderness.model;

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
	public Employee() {
		
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
