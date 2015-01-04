package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Column(name = "employee_name")
	private String employeeName;

    @Column(name = "employee_email")
	private String employeeEmail;

    @Id
    @Column(name = "employee_login")
	private String employeeLogin;

    @Column(name = "employee_password")
	private String employeePassword;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeLogin() {
		return employeeLogin;
	}
	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
}
