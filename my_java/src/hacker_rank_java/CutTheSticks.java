package hacker_rank_java;

import java.util.Scanner;

public class CutTheSticks {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int intN = scanner.nextInt();
		scanner.nextLine();
		int[] iStickLen = new int[intN];
		for (int i = 0; i < intN; i++) {
			iStickLen[i] = scanner.nextInt();
		}
		scanner.close();
		int iMin = 0;
		int iArraySum = Integer.MAX_VALUE;
		int whileLoopCounter = 0;
		while (iArraySum != 0) {
			iArraySum = 0;
			whileLoopCounter++;
			int iStickCutCount = 0;
			int iLoopMin = Integer.MAX_VALUE;
			for (int idx = 0; idx < intN; idx++) {
				int iStickValue = iStickLen[idx];
				// This is for the first time where no sticks are cut we are
				// just trying to get the min.
				if (iMin == 0) {
					if (iStickValue < iLoopMin) {
						iLoopMin = iStickValue;
					} // end of if (iStickValue < iLoopMin
					iArraySum = Integer.MAX_VALUE;
				} // end of if (iMin == 0) 
				else {
					//System.out.println("****whileLoopCounter:"+whileLoopCounter+"::iMin:" + iMin + "::iArraySum:"+iArraySum+"::iStickCutCount"+iStickCutCount);
					//System.exit(0);
					if (iStickValue != 0) {
						iStickValue = iStickValue - iMin;
						iStickLen[idx] = iStickValue;
						iStickCutCount++;
						if (iLoopMin > iStickValue && iStickValue!=0) {
							iLoopMin = iStickValue;
						} // end of if (iLoopMin > iStickValue)
					} // end of if (iStickValue != 0)
					iArraySum += iStickValue;
				} // end of else loop of if(iMin == 0)
			} // end of for (int idx = 0; idx < intN; idx++)
			iMin = iLoopMin;
			//System.out.println("****whileLoopCounter:"+whileLoopCounter+"::iMin:" + iMin + "::iArraySum:"+iArraySum+"::iStickCutCount"+iStickCutCount);
			
			if (iStickCutCount != 0) {
				System.out.println(iStickCutCount);
			} // end of if (iStickCutCount != 0)
		} // end of while (iArraySum != 0) 
	}
}
