package hacker_rank_java;

import java.util.Scanner;

public class AngryProfessor {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int iTestCases = scanner.nextInt();
		scanner.nextLine();
		String[] strOutputs = new String[iTestCases];
		for (int iTCIndex = 0; iTCIndex < iTestCases; iTCIndex++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();
			// int iLateCount = 0;
			int iEarlyCount = 0;
			for (int i = 0; i < n; i++) {
				int iTime = scanner.nextInt();
				if (iTime > 0) {
					// iLateCount++;
				} else {
					iEarlyCount++;
				}
			}
			if (scanner.hasNext()) {
				scanner.nextLine();
			}
			// System.out.println("k:"+k+"::iEarlyCount:"+iEarlyCount);
			strOutputs[iTCIndex] = iEarlyCount >= k ? "NO" : "YES";
		}
		for (String strOutput : strOutputs) {
			System.out.println(strOutput);
		}
		scanner.close();
	}
}
