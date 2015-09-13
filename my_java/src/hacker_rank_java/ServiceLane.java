package hacker_rank_java;

import java.util.Scanner;
public class ServiceLane {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int iFreeWayLen = scanner.nextInt();
		int iTC = scanner.nextInt();
		scanner.nextLine();
		int[] iWidth = new int[iFreeWayLen];
		for(int i=0;i<iFreeWayLen;i++) {
			iWidth[i]=scanner.nextInt();
		}
		int[] iOutput = new int[iTC];
		for(int iTCIdx=0;iTCIdx<iTC;iTCIdx++) {
			//if(scanner.hasNext()) {
				scanner.nextLine();
		    //}
			int iStartIndex = scanner.nextInt();
			int iEndIndex = scanner.nextInt();
			int iMin = Integer.MAX_VALUE;
			for(int idx = iStartIndex;idx<=iEndIndex;idx++) {
				if(iWidth[idx]<iMin) {
					iMin = iWidth[idx];
				}
			}
			iOutput[iTCIdx] = iMin;
		}
		scanner.close();
		for(int iOut:iOutput) {
			System.out.println(iOut);
		}
	}
}
