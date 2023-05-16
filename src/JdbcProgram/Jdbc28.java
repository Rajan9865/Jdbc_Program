package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Jdbc28 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			String queryString="select * from employee where employeeid";
			PreparedStatement ps1=con1.prepareStatement(queryString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//			Scanner sc1=new Scanner(System.in);
//			System.out.println("Enter the Employee id :");
//			int employeeid=sc1.nextInt();
//			ps1.setInt(1, employeeid);
			System.out.println("------------------------------");
			System.out.println("get values forward direction");
			System.out.println("-----------------------------");
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) 
			{
				System.out.print(" "+rs1.getInt(1));
				System.out.print(" "+rs1.getString(2));
				System.out.print(" "+rs1.getString(3));
				System.out.print(" "+rs1.getString(4));
				System.out.print(" "+rs1.getString(5));
				System.out.print(" "+rs1.getString(6));
				System.out.println();
			}
			System.out.println("-------------------------------");
			System.out.println("Get vlues backwarard directions ");
			System.out.println("---------------------------------");
			while (rs1.previous())
			{
				System.out.print(" "+rs1.getInt(1));
				System.out.print(" "+rs1.getString(2));
				System.out.print(" "+rs1.getString(3));
				System.out.print(" "+rs1.getString(4));
				System.out.print(" "+rs1.getString(5));
				System.out.print(" "+rs1.getString(6));
				System.out.println();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
