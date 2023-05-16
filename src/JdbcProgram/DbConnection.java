package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con1;
	static
	{
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
				con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	static Connection getconnect()
	{
		return con1;
		
	}
}
