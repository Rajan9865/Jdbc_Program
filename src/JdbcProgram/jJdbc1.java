package JdbcProgram;

public class jJdbc1 
{
	public static void main(String[] args) {
		try {
			Class class1=Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("file is loaded");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("file not loaded");
		}
	}

}
