package JdbcProgram;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc40 {
	public static void main(String[] args)throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo", "root", "root");
		PreparedStatement ps1=con1.prepareStatement(" select * from clobdemo");

		ResultSet rs1= ps1.executeQuery();
		rs1.next();
		
		System.out.println(rs1.getString(1));
		
		Reader re1=rs1.getCharacterStream(2);
		
		FileWriter fw1=new FileWriter("D:\\Java_practise_questions\\img\\bbtxt");
		int i;
		while ((i=re1.read())!=-1)
		{
			System.out.print((char)i);
			fw1.write((char)i);
			
		}
		fw1.close();
		
		
		
	}

}
