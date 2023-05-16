package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc17 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("established");
			Statement st1=con1.createStatement();
//			int row_count= st1.executeUpdate(" create table items1(id varchar(5),name varchar(25),price varchar(5), description varchar(50))");
			int row_count=st1.executeUpdate("alter table items1 drop column description");
//			if (row_count==0) {
//				System.out.println("creation failed");
//				
//			} else {
//				System.out.println("created successfully");
//
//			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
