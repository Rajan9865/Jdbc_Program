package JdbcProgram;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc12 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			System.out.println("connection established");
			
			System.out.println("-------------------------------");
			Statement st1=con1.createStatement();
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter the student id:-");
			String id=sc1.nextLine();
			
			System.out.println("Enter the Name:");
			String name=sc1.nextLine();
			
			System.out.println("Ebter the student age :");
			String age=sc1.nextLine();
			
			System.out.println("Enter the address:-");
			String address=sc1.nextLine();
			
			String sql_query="insert into students values("+id+",'"+name+"','"+age+"','"+address+"')";
			
			int rowcount= st1.executeUpdate(sql_query);
			if (rowcount>0) {
				System.out.println("-----------\r\n"+
			"values inserted succesfully\r\n");
				
			}
			else
			{
				System.out.println("-----------\r\n"+
						"values inserted failed \r\n");
							
			}
			
			con1.close();
			
			Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			Statement st2=con2.createStatement();
			ResultSet rs1=st2.executeQuery("select * from students");
			while (rs1.next()) {
				System.out.print(rs1.getString(1));
				System.out.print(" , "+rs1.getString(2));
				System.out.print(" , "+rs1.getString(3));
				System.out.print(" , "+rs1.getString(4));
				System.out.println();
				
			}
			System.out.println("reterive data successfully");
			con2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
