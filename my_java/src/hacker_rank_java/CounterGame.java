package hacker_rank_java;

/**
 * To check for power of 2 we need to (n & (n - 1)) == 0
 * To check if a x bit is set or not in value we 
 * can do (value>>x) & 1 == 1
 * To get the next power of 2 we can (n & (n+1)) << 1 
 */

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {
	public static BigInteger getNextPowerOf2(BigInteger n) {
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);
		if (n.and(nMinusOne).equals(BigInteger.ZERO)) {
			return n.divide(BigInteger.valueOf(2L));
		} else {
			BigInteger shiftedN = n;
			int msb = 0;
			while (!BigInteger.ZERO.equals(shiftedN)) {
				shiftedN = shiftedN.shiftRight(1);
				msb++;
			}
			return n.subtract(BigInteger.valueOf(2L).pow(msb-1));
			//return BigInteger.valueOf(2L).pow(msb-1);
		}
	}

	public static void main(String args[]) {

		//System.out.println(getNextPowerOf2(BigInteger.valueOf(31L)));
		//System.out.println(getNextPowerOf2(BigInteger.valueOf(9L)));
		 //System.out.println(getNextPowerOf2(BigInteger.valueOf(32L)));
		 Scanner scanner = new Scanner(System.in);
		 int iTestCases = scanner.nextInt();
		 String[] strOutput = new String[iTestCases];
		 for(int i=0;i<iTestCases;i++) {
			 scanner.nextLine();
			 String nValue = scanner.next();
			 BigInteger bigValue = new BigInteger(nValue);
			 int iStepCount = 0;
			 //boolean boolLouie = false;
			 while(!bigValue.equals(BigInteger.ONE)) {
				 //System.out.println(bigValue.toString()+"::whose turn:"+boolLouie);
				 bigValue = getNextPowerOf2(bigValue);
				 //System.out.println("****bigValue:"+bigValue);
				 iStepCount++;
				 //System.out.println((boolLouie?"Louie":"Richard")+" finished a turn and new value is "+bigValue);
				 //System.out.println(bigValue);
			 }
			 //System.out.println(boolLouie?"Louie":"Richard");
			 strOutput[i]=(iStepCount & 1)==1?"Louise":"Richard";
		 }
		 scanner.close();
		 for(String op:strOutput) {
			 System.out.println(op);
		 }
		// System.out.println(Integer.MAX_VALUE);
	}
}
