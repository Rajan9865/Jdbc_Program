package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class Jdbc32 {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		PreparedStatement ps1=con1.prepareStatement("select * from students");
		ResultSet rs1= ps1.executeQuery();
//		ResultSetMetaData ms1=rs1.getMetaData();
		
		ResultSetMetaData md1=rs1.getMetaData();
//		System.out.println(md1.getColumnCount());
//		System.out.println(md1.getColumnName(1));
//		System.out.println(md1.getColumnName(2));
//		System.out.println(md1.getColumnName(3));
//		System.out.println(md1.getColumnName(4));
		
		int no_ofcoName=md1.getColumnCount();
		
		for(int i=1;i<=no_ofcoName;i++)
		{
			System.out.print(md1.getColumnName(i) );
			System.out.print("\t\t"+md1.getColumnTypeName(i));
			System.out.println("\t\t"+md1.getColumnDisplaySize(i));
		}
//		while (rs1.next()) 
//		{
//			System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3)+"\t"+rs1.getString(4));
//		}
	}

}
