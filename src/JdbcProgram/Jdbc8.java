package JdbcProgram;
///*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//*/
//import java.sql.*;


public class Jdbc8 {
	public static void main(String[] args) {
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(" select * from emp");
			while (rs.next())
			{  
//				rs.getString(1);
				System.out.print(rs.getString(1));
				System.out.print(" "+", "+rs.getString(2));
				System.out.println();
//				System.out.println(rs);
				
			}
			
			
//			System.out.println("driver is loaded ");
//			System.out.println("connection established");
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("driver is not loaded");
			e.printStackTrace();
		}
		
	}

}
