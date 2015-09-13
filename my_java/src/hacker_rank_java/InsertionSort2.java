package hacker_rank_java;

import java.util.Scanner;

public class InsertionSort2 {
    static int iCounter = 0;
	public static void printArray(int[] iArr,String prefix) {
		System.out.print(prefix);
		for (int i : iArr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static int[] convertIntArray(String str, int iLen) {
		String[] strArr = str.split(" ");
		int[] iArr = new int[iLen];
		for (int i = 0; i < iLen; i++) {
			iArr[i] = Integer.parseInt(strArr[i]);
		}
		return iArr;
	}

	public static void sort(String str, int iLen) {
		int[] iArr = convertIntArray(str, iLen);
		for (int iRefPtr = 0; iRefPtr < iLen - 1; iRefPtr++) {
			int iCompPtr = iRefPtr + 1;
			if (iArr[iCompPtr] < iArr[iRefPtr]) {
				// now we need to insert the element in right place
				//System.out.println("******iArr[iCompPtr]"+iArr[iCompPtr]+"::iArr[iRefPtr]:"+iArr[iRefPtr]);
				int iInsertionIndex = iRefPtr;
				int iInsertionValue = iArr[iCompPtr]; 
				
				//System.out.println("***iInsertionIndex:"+iInsertionIndex+"::iInsertionValue:"+iInsertionValue);
				while (iInsertionIndex >= 0
						&& iInsertionValue < iArr[iInsertionIndex]) {
					int iTemIndex = iInsertionIndex+1;
					iArr[iTemIndex]= iArr[iInsertionIndex];
					//printArray(iArr,iInsertionValue+"--------"+iInsertionIndex+"----");
					//if(iInsertionIndex!=0) {
						iInsertionIndex--;
						iCounter++;
					//} else {
					//	break;
					//}
				}
				iArr[iInsertionIndex+1]=iInsertionValue;
				//printArray(iArr,"");
			} else {
				//printArray(iArr,"");
			}

		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int iLen = Integer.parseInt(scanner.nextLine());
		String strArray = scanner.nextLine();
		InsertionSort2.sort(strArray, iLen);
		scanner.close();
		System.out.println(iCounter);
	}
}
