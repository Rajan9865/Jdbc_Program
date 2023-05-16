package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc4 
{
	public static void main(String[] args) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306/jdbc", "root", "root");
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=Asia/Shanghai","root","root");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			System.out.println("established");

			Statement statement=con.createStatement();
			
//			String query="create table emp (Eno int(3) primary key, Ename varchar(10)"));
			String query= "create table emp12 (Eno int (5) primary key, Ename varchar(20))";
//					
					statement.executeUpdate(query);
			System.out.println("table is created succesfully");
			
			statement.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
