package hacker_rank_java;
import java.util.Scanner;
public class GemStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int iTC = scanner.nextInt();
		scanner.nextLine();
		int iAndValue = 0x3FFFFFF;
		int iAAscii = (int)'a';
		//System.out.println(Integer.toBinaryString(iAndValue)+"::length is "+
		      //(Integer.toBinaryString(iAndValue)+"").length());
		//System.out.println(Integer.toBinaryString(1<<3));
		//System.out.println(Integer.toBinaryString(1<<0));
		for(int idx=0;idx<iTC;idx++) {
		    	String strTC = scanner.nextLine();
		    	int iStrLen = strTC.length();
		    	int iBitMap = 0;
		    	for(int i=0;i<iStrLen;i++) {
		    		int iAscValue = (int)strTC.charAt(i) - iAAscii;
		    		iBitMap = iBitMap | 1 << iAscValue;
		    	}
		    	iAndValue = iAndValue & iBitMap;
	    		//System.out.println(Integer.toBinaryString(iAndValue));
		}
		scanner.close();
		System.out.println(Integer.bitCount(iAndValue));
	}

}
