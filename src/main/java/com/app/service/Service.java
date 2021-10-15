package com.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.employeeModel.Employee;

public interface Service {
	public boolean  addEmployee(Employee employee) throws ClassNotFoundException;  
	
	public List<Employee> getAllEmployee() throws SQLException;
	
	public boolean editEmployee(Employee employee)throws SQLException;
	
	public Employee getEmployeeById(int EmployeeID);
}
