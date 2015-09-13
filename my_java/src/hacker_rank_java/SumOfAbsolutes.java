package hacker_rank_java;
import java.util.Scanner;
public class SumOfAbsolutes {
	String[] strNumbers;
	
	public String sumOfAbsolutes(int startIndex,int endIndex) {
		long longSum = 0;
		//long bitMask = 1L;
		for(int currIndex=startIndex-1;currIndex<endIndex;currIndex++){
			long lNumber = Long.parseLong(strNumbers[currIndex]);
			longSum=Math.abs(longSum+lNumber);
		}
		return (longSum&1)==0?"Even":"Odd";
	}
	public static void main(String args[]) {
	    Scanner scanner = new Scanner(System.in);
	    String lineWithNQ = scanner.nextLine();
	    SumOfAbsolutes sumOfAbsolutesObj = new SumOfAbsolutes();
	    sumOfAbsolutesObj.strNumbers = scanner.nextLine().split(" ");
	    long lNumberOfQueries = Long.parseLong(lineWithNQ.split(" ")[1]);
	    for(long queryIndex=0;queryIndex<lNumberOfQueries;queryIndex++) {
	    	String[] queryLineParams = scanner.nextLine().split(" ");
	    	int startIndex = Integer.parseInt(queryLineParams[0]);
	    	int endIndex = Integer.parseInt(queryLineParams[1]);
	    	System.out.println(sumOfAbsolutesObj.sumOfAbsolutes(startIndex,endIndex));
	    }
	    scanner.close();
	}

}
