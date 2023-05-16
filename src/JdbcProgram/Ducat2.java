package JdbcProgram;

public class Ducat2
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
