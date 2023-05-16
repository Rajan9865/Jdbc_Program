package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Jdbc31 {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		Statement st1=con1.createStatement();
		st1.addBatch("insert into students values(101,'nisha',23,'darbhanga')");
		st1.addBatch("insert into students values(102,'nani',25,'axaual')");
		st1.addBatch("insert into students values(103,'rajan',25,'patana')");
		st1.addBatch("insert into students values(104,'mara',24,'moida')");
		st1.addBatch("insert into students values(105,'nandani',30,'setor15')");
		int[] rowCount= st1.executeBatch();
		for(int i:rowCount)
		{
			System.out.println(i+" row manipulated");
		}
		con1.close();
	} catch (ClassNotFoundException|SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
}
}
