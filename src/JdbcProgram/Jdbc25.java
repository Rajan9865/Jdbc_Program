package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc25 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("Jdbc:mysql://localhost:3306/jdbc", "root", "root");
//			Statement st1=con1.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			Statement st1=con1.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
			ResultSet rs1=st1.executeQuery(" select * from employee");
			while (rs1.next()) 
			{
				System.out.print(rs1.getInt(1));
				System.out.print(" , "+rs1.getString(2));
				System.out.print(" , "+rs1.getString(3));
				System.out.print(" , "+rs1.getString(4));
				System.out.print(" , "+rs1.getString(5));
				System.out.print(" , "+rs1.getString(6));
				System.out.println();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
