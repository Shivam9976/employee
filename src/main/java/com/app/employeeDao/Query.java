package com.app.employeeDao;

public class Query {
	public static final String INSERT_QUERY = "INSERT INTO employee (name,address) VALUES('?','?');";
	public static final String UPDATE_QUERY = "UPDATE  `employee` SET `name`='?', `address`='?' WHERE `id`='?';";
	public static final String GET_EMPLOYEE_BY_ID ="select id,name ,address from employee where id = ?;";
}
