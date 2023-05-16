package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ducat4 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			Statement st1=con1.createStatement();
			st1.executeUpdate("create table emp3(name varchar(30),salary int)");
			st1.close();
			
			PreparedStatement ps1=con1.prepareStatement("insert into emp3 values(?,?)");
			ps1.setString(1, "Rajan");
			ps1.setInt(1, 101);
			
			ps1.executeUpdate();
			ps1.close();
			ps1=con1.prepareStatement("select * from emp3 where salary=?");
			ps1.setInt(1, 101);
			
			ResultSet rs1=ps1.executeQuery();
			
			
			while (rs1.next()) 
			{
				System.out.println("name\t"+rs1.getString("Rajan"));
				System.out.println("salary\t"+rs1.getInt(101));
				
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
