package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Jdbc19 {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("established");
		PreparedStatement ps1=con1.prepareStatement("select * from employee where EmployeeID=?");
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the id:-");
		int id=sc1.nextInt();
		ps1.setInt(1, id);
		ResultSet rs1=ps1.executeQuery();
		while (rs1.next()) 
		{
			System.out.println("employee id:"+rs1.getString(1));
			System.out.println(" First name "+rs1.getString(2));
			System.out.println(" last name "+rs1.getString(3));
			System.out.println(" Email "+rs1.getString(4));
			System.out.println(" Addreline "+rs1.getString(5));
			System.out.println(" City "+rs1.getString(6));
			
		}
		
	}

}
