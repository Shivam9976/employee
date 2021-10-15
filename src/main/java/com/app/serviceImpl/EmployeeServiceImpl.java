package com.app.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.app.employeeDao.EmployeeDao;
import com.app.employeeModel.Employee;
import com.app.service.Service;

public class EmployeeServiceImpl implements Service {

	EmployeeDao employeeDao = new EmployeeDao();

	@Override
	public boolean addEmployee(Employee employee) throws ClassNotFoundException {

		return employeeDao.insertRecord(employee);
	}

	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		return employeeDao.getAllEmployee();
	}

	@Override
	public boolean editEmployee(Employee employee) throws SQLException {
		 
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int EmployeeId) {
		return  employeeDao.getEmployeeById(EmployeeId);
	}
	 
}
