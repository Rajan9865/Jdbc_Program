package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbc21 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("established");
			PreparedStatement ps1=con1.prepareStatement(" delete from employee where Employeeid=?");
			System.out.println("Enter the employee id:-");
			Scanner sc1=new Scanner(System.in);
			int id=sc1.nextInt();
			ps1.setInt(1, id);
			int rowCount=ps1.executeUpdate();
			if (rowCount>0) 
			{
				System.out.println("delete succesfull");
				
			} else {
				System.out.println("not deleted items");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
