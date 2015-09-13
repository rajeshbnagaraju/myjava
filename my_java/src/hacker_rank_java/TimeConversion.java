package hacker_rank_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		scanner.close();
		
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ssa"); //hh:mm:ssAM
		Date curDate = null;
		try {
			curDate = ft.parse(inputString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("****curDate:"+curDate);
	    String DateToStr = ft.format(curDate);
	    ft = new SimpleDateFormat("HH:mm:ss");
	    DateToStr = ft.format(curDate);
	    System.out.println(DateToStr);

		
	}

}
