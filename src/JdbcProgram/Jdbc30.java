package JdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Jdbc30 {
	public static void main(String[] args) {
		try {Class.forName("com.mysql.cj.jdbjc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			con1.setAutoCommit(false);
			Statement st1=con1.createStatement();
			st1.executeUpdate("insert into students values(101,'nisha',23,'darbhanga')");
			st1.executeUpdate("insert into students values(102,'nani',25,'axaual')");
			st1.executeUpdate("insert into students values(103,'rajan',25,'patana')");
			Savepoint sp1=con1.setSavepoint();
			st1.executeUpdate("insert into students values(104,'mara',24,'moida')");
			con1.releaseSavepoint(sp1);
			st1.executeUpdate("insert into students values(105,'nandani',30,'setor15')");
			System.out.println("inserted");
			con1.rollback(sp1);
			con1.commit();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
