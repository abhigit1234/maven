package demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Dates {
	public static void main(String[] args) {
		
//====================================================Date 1 =======================
//		Calendar cal = Calendar.getInstance();
//		Date time = cal.getTime();
//		System.out.println(time);

	
//=====================================================Date 2========================		
	
//		Calendar cal = Calendar.getInstance();
//		String time = cal.getTime().toString().replace("", "").replace(":", " ");
//		System.out.println(time);

//======================================================Date 3========================	
	
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	System.out.println(ldt.format(dtf));
		
	}
}
