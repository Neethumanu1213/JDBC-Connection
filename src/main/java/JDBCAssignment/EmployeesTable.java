package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesTable {

	public static void main(String[] args) throws SQLException {

		Connection connection;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "password@123");

		System.out.println("Connection is established");
		ResultSet resultSet;
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery("select max(salary) ,min(salary) from employees");

		while (resultSet.next()) {
			String maxSalary = resultSet.getString("max(salary)");
			String minSalary = resultSet.getString("min(salary)");
			System.out.println("The max salary is " + maxSalary);
			System.out.println("The max salary is " + minSalary);
		}

		
		ResultSet resultSet2;
		resultSet2 = statement.executeQuery("select salary from employees order by  salary desc limit 1,1");
		while (resultSet2.next()) {
			String salary=resultSet2.getString("salary");
			System.out.println("Second largest salary is : "+salary);			
		}

		connection.close();
	}

}
