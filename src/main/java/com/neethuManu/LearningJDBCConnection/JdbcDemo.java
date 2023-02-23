package com.neethuManu.LearningJDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		
		Connection connection;
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe", "root", "password@123");

		ResultSet resultSet;
		System.out.println("Connection established");
		
		Statement statement=connection.createStatement();
		String queryForFirstnameFromEmplyee="select * from employee";
		resultSet=statement.executeQuery(queryForFirstnameFromEmplyee);
		System.out.println(resultSet);
		
//		while(resultSet.next()) {
//			String firstName=resultSet.getString("first_name");
//			System.out.println(firstName);
//			
//		}
		
		ArrayList<EmployeeTable> list=new ArrayList<>();
		while(resultSet.next()) {
			EmployeeTable employeeTable=new EmployeeTable();
			employeeTable.setFirst_name(resultSet.getString("first_name"));
			list.add(employeeTable);
		}
		System.out.println(list.get(0).getFirst_name());
		connection.close();
		
	}

}
