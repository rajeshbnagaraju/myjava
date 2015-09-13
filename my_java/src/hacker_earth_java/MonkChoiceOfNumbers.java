package hacker_earth_java;

import java.util.Scanner;

public class MonkChoiceOfNumbers {
	
	public static  long getMaxChocolates(int[] iValues,int iKSize) {
		//int iMaxChocolates = 0;
		int iLen = iValues.length;	
		int iEnd = 0;
		long iMaxSetBits = 0;
		for(int idx=0;iEnd<iLen;idx++) {
			int iStart = idx;
			iEnd = idx+iKSize;
			int iTempSetBits = getSetBits(iValues,iStart,iEnd);
			//System.out.println("iTempSetBits:"+iTempSetBits+"::iMaxSetBits:");
			if(iTempSetBits>iMaxSetBits) {
				iMaxSetBits = iTempSetBits;
			}
		}
		return iMaxSetBits;
	}
	public static int getSetBits(int[] iValues,int iStart, int iEnd) {
		//int iLen = iValues.length;
		int iSetBits = 0;
		for (int iOuterIdx = iStart; iOuterIdx < iEnd; iOuterIdx++) {
				int iValue = iValues[iOuterIdx];
				while (iValue != 0) {
					if ((iValue & 1) != 0) {
						iSetBits++;
					}
					iValue = iValue >> 1;
				}
		}
		//System.out.println("iStart:"+iStart+"::iEnd:"+iEnd+"::iSetBits:"+iSetBits);
		return iSetBits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int iTestCases = scanner.nextInt();
		scanner.nextLine();
		long[] iOutputs = new long[iTestCases];
		for (int iTC = 0; iTC < iTestCases; iTC++) {
			int iNSize = scanner.nextInt();
			int iKSize = scanner.nextInt();
			scanner.nextLine();
			int[] iValues = new int[iNSize];
			for (int idx = 0; idx < iNSize; idx++) {
				iValues[idx] = scanner.nextInt();
			}
			iOutputs[iTC]=getMaxChocolates(iValues, iKSize);
		}
		scanner.close();
		for(int iOutIdx=0;iOutIdx<iTestCases;iOutIdx++){
			System.out.println(iOutputs[iOutIdx]);
		}
	}

}
