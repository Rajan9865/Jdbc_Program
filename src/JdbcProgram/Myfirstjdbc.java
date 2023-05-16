package JdbcProgram;

import java.sql.DriverManager;

public class Myfirstjdbc {
	
public static void main(String[] args) 
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
}
