package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc6 {
	public static void main(String[] args) {
		try {
			//loaded driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// coneection established
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			// create Statement
			Statement statement=connection.createStatement();
			//
			long i=statement.executeUpdate("insert into emp values(1,'Rajan' )");
			
			if (i>0) {
				System.out.println("record succefully");
			} else {
				System.out.println("not Record");
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
