package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc13 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("connection established");
			Statement st1=con1.createStatement();
			ResultSet rs1= st1.executeQuery(" select * from students");
			while (rs1.next()) 
			{
				System.out.print(rs1.getString(1));
				System.out.print(" , "+rs1.getString(2));
				System.out.print(" , "+rs1.getString(3));
				
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
