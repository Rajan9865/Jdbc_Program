package JdbcProgram;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jdbc34 {
	public static void main(String[] args) {
		Date d1=new Date();
		System.out.println(d1.getDate());
//		System.out.println(d1.getTime());
		// Date
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println(sdf1.format(d1));
		String date1=sdf1.format(d1);
		System.out.println(date1);
		
		//Time
		SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss");
		String time1=sdf2.format(d1);
//		System.out.println(sdf2.format(d1));
		System.out.println(time1);
		
		
//		second way
		long l1= System.currentTimeMillis();
		Date dd1=new Date();
		System.out.println(dd1);
		
		
		
	}

}
