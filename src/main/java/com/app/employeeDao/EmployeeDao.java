package com.app.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.config.DatabaseConnection;
import com.app.employeeModel.Employee;

public class EmployeeDao {

	public boolean insertRecord(Employee employee) throws ClassNotFoundException {
		boolean status = false;
		try {
			String query = "INSERT INTO employee (name,address) VALUES (?, ?)";
			Connection conn = DatabaseConnection.connetion();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getAddress());
			if (pstmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("error in adding student");
			e.printStackTrace();
		}
		return status;
	}

	public List<Employee> getAllEmployee() throws SQLException {
		String query = "select * from employee";
		List<Employee> list = new ArrayList<Employee>();
		Employee emp;
		try {
			Connection conn = DatabaseConnection.connetion();
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery(query);
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAddress(rs.getString(3));
				list.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean updateEmployee(Employee employee) throws SQLException {
		String query = Query.UPDATE_QUERY;
		boolean status = false;
		try {
			Connection conn = DatabaseConnection.connetion();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(3,employee.getId());
			stmt.setString(2,employee.getAddress());
			stmt.setString(1,employee.getName());
			if(stmt.executeUpdate()>0) {
				status = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		return status;
	}
	public Employee getEmployeeById(int EmployeeId) {
		
		String query = Query.GET_EMPLOYEE_BY_ID;
		Employee e = null ;
		try {
			Connection conn = DatabaseConnection.connetion();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1,EmployeeId);
			ResultSet rs =stmt.executeQuery();
			if(rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setAddress(rs.getString("address"));
				e.setName(rs.getString("name"));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
}
