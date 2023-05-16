package JdbcProgram;

public class Jdbc7 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver is loaded scuccesfully");
	}

}
