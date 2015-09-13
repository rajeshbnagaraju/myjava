package hacker_rank_java;
import java.text.DecimalFormat;
import java.util.Scanner;
public class PlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int numOfElements = Integer.parseInt(scanner.nextLine());
		String[] strLineToks = scanner.nextLine().split(" ");
		scanner.close();
		double iNegCount = 0;
		double iZeroCount = 0;
		int ilen = strLineToks.length; 
		for(int index=0;index<ilen;index++){
			if(strLineToks[index].equals("0")) {
				iZeroCount++;
			} else if(strLineToks[index].startsWith("-")) {
				iNegCount++;
			}
		} 
		DecimalFormat four = new DecimalFormat();
	    four.setMaximumFractionDigits(3);
		four.setMinimumFractionDigits(3);
		System.out.println(four.format((numOfElements-(iNegCount+iZeroCount))/numOfElements));
		System.out.println(four.format(iNegCount/numOfElements));
		System.out.println(four.format(iZeroCount/numOfElements));
		
		
	}

}


  