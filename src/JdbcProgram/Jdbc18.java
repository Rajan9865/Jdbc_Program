package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Jdbc18 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
//			PreparedStatement ps1=con1.prepareStatement("insert  into employee values(101,'rajan','Kumar','rajan@gmail.com','patna','raxaul,");
			PreparedStatement ps1=con1.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps1.setInt(1, 102);
			ps1.setString(2, "niha");
			ps1.setString(3, "kumari");
			ps1.setString(4, "nisha@gmail.com");
			ps1.setString(5, "Bihar");
			ps1.setString(6, "darbhanga");
			int rowCount=ps1.executeUpdate();
			if (rowCount>0) {
				System.out.println(" 1st recorted inserted");
				
			} else {
				System.out.println("1st not recored inserted");

			}
			ps1.setInt(1, 103);
			ps1.setString(2, "Ram");
			ps1.setString(3, "kumar");
			ps1.setString(4, "Ram@gmail.com");
			ps1.setString(5, "Bihar");
			ps1.setString(6, "sitamarhi");
			int rowCount1=ps1.executeUpdate();
			if (rowCount1>0) {
				System.out.println(" 2nd recorted inserted");
				
			} else {
				System.out.println("2nd not recored inserted");

			}
			ps1.setInt(1, 104);
			ps1.setString(2, "Shyam");
			ps1.setString(3, "kumar");
			ps1.setString(4, "shyam@gmail.com");
			ps1.setString(5, "delhi");
			ps1.setString(6, "noida");
			int rowCount2=ps1.executeUpdate();
			if (rowCount2>0) {
				System.out.println(" 3rd recorted inserted");
				
			} else {
				System.out.println("3rd not recored inserted");

			}
			ps1.setInt(1, 105);
			ps1.setString(2, "Jitu");
			ps1.setString(3, "kumar");
			ps1.setString(4, "jitu@gmail.com");
			ps1.setString(5, "delhi");
			ps1.setString(6, "laxmi nagar");
			int rowCount3=ps1.executeUpdate();
			if (rowCount3>0) {
				System.out.println(" 4th recorted inserted");
				
			} else {
				System.out.println("4th not recored inserted");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
