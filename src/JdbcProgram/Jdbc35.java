package JdbcProgram;

import java.text.SimpleDateFormat;
//import java.lang.ref.Cleaner;
import java.util.Calendar;

public class Jdbc35 {
	public static void main(String[] args) {
		Calendar c1=Calendar.getInstance();
//		c1.getTime();
		System.out.println(c1.getTime());
		
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf1.format(c1.getTime()));
		
		
//		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
		System.out.println(sdf2.format(c1.getTime()));
	}

}
