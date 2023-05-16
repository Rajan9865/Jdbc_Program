package JdbcProgram;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc39 {
public static void main(String[] args)throws Exception 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo", "root", "root");
	PreparedStatement ps1=con1.prepareStatement(" insert into clobdemo values(?,?)");
	ps1.setString(1, "deepka");
	
	//=========================================
	FileReader fr1=new FileReader("D:\\Java_practise_questions\\img\\aa.txt");
			ps1.setCharacterStream(2, fr1);
			int rowCount=ps1.executeUpdate();
			if (rowCount>0)
			{
				System.out.println("imseretd successfully");
				
			} else {
				System.out.println("not inserted");
			}
	
			
	
}
}
