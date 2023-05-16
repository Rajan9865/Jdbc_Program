package JdbcProgram1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	static Connection con;
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	static Connection getConnect()
	{
		return con;
	}
}
