package JdbcProgram;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc37 {
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo", "root", "root");
	PreparedStatement ps1=con1.prepareStatement(" insert into blobdemo values(?,?)");
	ps1.setString(1, "Deepak");
	
//	input stroing
	FileInputStream fileInputStream=new FileInputStream("D:\\pic.jpg");
	
	ps1.setBinaryStream(2, fileInputStream);
	int rowCount=ps1.executeUpdate();
	if (rowCount>0) 
	{
		System.out.println("inserted successfully");
		
	} else {
		System.out.println("inserted unsuccessfull");

	}
	
}
}
