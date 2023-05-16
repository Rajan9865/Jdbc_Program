package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbc20 {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		System.out.println("estsblished");
		PreparedStatement ps1=con1.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		Scanner sc1=new Scanner(System.in);
		while (true) 
		{
			System.out.println("Enter employee id:-");
			int id=sc1.nextInt();
			System.out.println("Enter employee first name:-");
			String fname1=sc1.next();
			System.out.println("Enter employee Lname:-");
			String lname1=sc1.next();
			System.out.println("Enter employee Email:-");
			String email=sc1.next();
			System.out.println("Enter employee State:-");
			String state=sc1.next();
			System.out.println("Enter employee City:-");
			String city=sc1.next();
			
			ps1.setInt(1, id);
			ps1.setString(2, fname1);
			ps1.setString(3, lname1);
			ps1.setString(4, email);
			ps1.setString(5, state);
			ps1.setString(6, city);
			
//			ps1.execute
//			ps1.executeu
			int roeCount=ps1.executeUpdate();
			if (roeCount>0) 
			{
				System.out.println("inserted succesfully");
				
			} else {
				System.out.println("not iserted");

			}
			System.out.println(" do you want to insert another query (y/n)");
			String yn=sc1.next();
			if (yn.equals("y")) 
			{
				continue;
			} else {
				break;
			}
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
}
