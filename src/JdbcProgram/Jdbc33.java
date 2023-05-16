package JdbcProgram;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc33 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
//		PreparedStatement ps1=con1.prepareStatement("select * from students");
		
		DatabaseMetaData md1= con1.getMetaData();
		System.out.println(md1.getDatabaseProductName());
		System.out.println(md1.getDatabaseProductVersion());
		System.out.println(md1.getDatabaseMinorVersion());
		System.out.println(md1.getDatabaseMajorVersion());
//		System.out.println(md1.getSQLKeywords());
		System.out.println(md1.supportsBatchUpdates());
		System.out.println(md1.supportsStoredFunctionsUsingCallSyntax());
		
		
	}
	

}
