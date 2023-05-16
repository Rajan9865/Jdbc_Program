package JdbcProgram;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Jdbc23 {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con1=DriverManager.getConnection("mysql:jdbc://localhost:3306/jdbc", "root", "root");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("estsblished");
		CallableStatement cs1=con1.prepareCall("{call getAllEmpData()}");
		ResultSet rs1= cs1.executeQuery();
		
		while (rs1.next()) 
		{
			System.out.println("mployye id :-"+rs1.getInt(1));
			System.out.println("employee First name :-"+rs1.getString(2));
			System.out.println("employee Last name :-"+rs1.getString(3));
			System.out.println("employee Email :-"+rs1.getString(4));
			System.out.println("employee State :-"+rs1.getString(5));
			System.out.println("employee City :-"+rs1.getString(6));
			System.out.println("----------------------------");
			
		}
		con1.close();
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
}
