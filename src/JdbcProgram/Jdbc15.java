package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc15 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("established");
			Statement st1=con1.createStatement();
			int row_count= st1.executeUpdate("update students set address='Raxaul' where id=4");
			if (row_count>0) {
				System.out.println("uopdate succesfully");
				
			} else {
				System.out.println("not updated");

			}
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
