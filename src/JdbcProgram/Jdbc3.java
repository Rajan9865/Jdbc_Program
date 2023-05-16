package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc3 
{
	public static void main(String[] args) 
	{
		// load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			
			Statement statement=con.createStatement();
			
//			String query="create table emp (Eno int(3) primary key, Ename varchar(10)"));
			String query="create table emp3 (Eno int (6) primary key, Ename varchar(20))";
//					
					statement.executeUpdate(query);
			System.out.println("table is created succesfully");
			
			statement.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
