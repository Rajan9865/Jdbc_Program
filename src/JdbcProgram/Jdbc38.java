package JdbcProgram;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc38 {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo", "root", "root");
		PreparedStatement ps1=con1.prepareStatement(" select * from blobdemo ");
		ResultSet rs1=ps1.executeQuery();
		while (rs1.next())
		{
			System.out.println(rs1.getString(1));
			FileOutputStream fo1=new FileOutputStream("D:\\Java_practise_questions\\img\\abc.jpg");
			InputStream is1=rs1.getBinaryStream(2);
			int val=is1.read();
			
			while (val !=-1) {
				fo1.write(val);
				val=is1.read();
				
			}
			System.out.println("mage saved successfully");
		}
		
	}

}
