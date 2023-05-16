package JdbcProgram;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jdbc36 {
	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());
		
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime ldt1=LocalDateTime.now();
		String date1=dtf1.format(ldt1);
		System.out.println(date1);
		
//		time
		
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalDateTime ldt2=LocalDateTime.now();
		String time1=dtf2.format(ldt1);
		System.out.println(time1);
	}

}
