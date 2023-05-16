package JdbcProgram;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc24 {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("onnection established");
		CallableStatement sc1=con1.prepareCall("{select * from employee(?)}");
	}

}
