package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbc22 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("established");
			PreparedStatement ps1=con1.prepareStatement(" update employee set FirstName=?, LastName=? where employeeid=?");
			System.out.println("enter the employee id:-");
			Scanner sc1=new Scanner(System.in);
			int id=sc1.nextInt();
			
			System.out.println("Enter the First name:-");
			String FirstName=sc1.next();
			
			System.out.println("Enter the last name:-");
			String LastName=sc1.next();
			
			ps1.setString(1, FirstName);
			ps1.setString(2, LastName);
			ps1.setInt(3, id);
			
			int row_count=ps1.executeUpdate();
			if (row_count>0) 
			{
				System.out.println("updated successfully");
				
			} else {
				System.out.println("not updated ");

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
