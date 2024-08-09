package demo;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidatingWithExceptionMessage {
	public static void main(String[] args) throws Exception  {


	String targetdate = "30/feb/1989";
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yyyy");
	try {
		dateformat.setLenient(false);
		Date formatteddate = dateformat.parse(targetdate);
		System.out.println(formatteddate);
	} catch (ParseException e) {
		throw new Exception("Invalid date entered");
	}
	
	
	
	
	
	}
}