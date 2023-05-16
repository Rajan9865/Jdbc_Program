package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc16 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			Statement st1=con1.createStatement();
			int row_count= st1.executeUpdate(" delete from students where age='103'");
			System.out.println("values "+row_count);
			
			if (row_count>0) 
			{
				System.out.println("delete successfully");
				
			} else {
				System.out.println("delete unsuccessfully");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
