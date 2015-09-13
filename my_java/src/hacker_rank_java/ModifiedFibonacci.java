package hacker_rank_java;

import java.math.BigDecimal;
import java.util.Scanner;

public class ModifiedFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int intA = scanner.nextInt();
		int intB = scanner.nextInt();
		int intN = scanner.nextInt();
		scanner.close();
		if (intN < 2) {
			int printNum = intN == 0 ? intA : intB;
			System.out.println(printNum);
		} else {
			BigDecimal[] bigDec = new BigDecimal[intN];
			bigDec[0] = BigDecimal.valueOf(intA);
			bigDec[1] = BigDecimal.valueOf(intB);
			for (int idx = 2; idx < intN; idx++) {
				int less2= idx -2;
				int less1 = idx -1;
				bigDec[idx] = bigDec[less2].add(bigDec[less1].multiply(bigDec[less1]));
			}
			System.out.println(bigDec[intN-1]);
		}
	}
}
