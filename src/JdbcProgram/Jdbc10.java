package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc10 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			System.out.println("connection established");
			Statement st1=con1.createStatement();
			Scanner sc1=new Scanner(System.in);
			System.out.println("enter the sql query:");
			String sql_query=sc1.nextLine();
//			System.out.println(sql_query);
			 ResultSet rs=st1.executeQuery(sql_query);
			while (rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print(" , "+rs.getString(2));
				System.out.print(" , "+rs.getString(3));
				System.out.print(" , "+rs.getString(4));
				System.out.print(" , "+rs.getString(5));
				System.out.print(" , "+rs.getString(6));
				System.out.print(" , "+rs.getString(7));
				System.out.print(" , "+rs.getString(8));
				System.out.println();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
