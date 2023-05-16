package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc2 
{
	public static void main(String[] args) 
	{
		try {
			Class class1=Class.forName("com.mysql.cj.jdbc.Driver");
//			Class csClass=Class.forName("com.mysql.jdbc.Driver");
//			Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3036/company","root","root");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practise", "root", "root");
			System.out.println(con);
			System.out.println("connection  established");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection not established");
		}
		
	}

}
