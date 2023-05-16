package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc9 {
	public static void main(String[] args) {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root", "root");
			Statement st=con.createStatement();
//			ResultSet rs=st.executeQuery("select * from emp");
			ResultSet rs=st.executeQuery("select Fname,Lname,age from emp");
			while (rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print(" , "+rs.getString(2));
				System.out.print(" , "+rs.getString(3));
//				System.out.print(" , "+rs.getString(4));
//				System.out.print(" , "+rs.getString(5));
//				System.out.print(" , "+rs.getString(6));
//				System.out.print(" , "+rs.getString(7));
//				System.out.print(" , "+rs.getString(8));
				System.out.println();
			}
			
			System.out.println("connecftion estatblished");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
