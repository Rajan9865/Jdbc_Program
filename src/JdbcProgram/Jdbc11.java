package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc11 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			System.out.println("connedtion establisgedf");
			Statement st1=con1.createStatement();
//			int rowcount=st1.executeUpdate("insert into emp values(9,"Nisha","bharti",25,"java fullstack","darbhanga",16999,"843471338")");
			int rowcount=st1.executeUpdate("insert into emp values(9,'Nisha','bharti',25,'fullstack','darnhanga',16999,'8340414898')");
				
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
