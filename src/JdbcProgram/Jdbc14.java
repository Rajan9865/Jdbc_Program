package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc14 {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loades");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("connection established");
		Statement st1=con1.createStatement();
		int rowcount= st1.executeUpdate("insert into students values(6,'qaaaaa',103,'bbbc')");
		if (rowcount>0) 
		{
			System.out.println("Stored successfully");
		} else {
			System.out.println("failed");
		}
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		// TODO: handle exception
	}
}
}
