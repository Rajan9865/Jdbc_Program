package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc5
{
	public static void main(String[] args) 
	{
		try 
		{
			// load driver class 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			// Create Statement
			System.out.println(connection);
			Statement statement=connection.createStatement();
			System.out.println(statement);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			// TODO: handle exception
		}
		
	}
}
