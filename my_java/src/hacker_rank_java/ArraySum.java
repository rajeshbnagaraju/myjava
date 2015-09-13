package hacker_rank_java;

import java.util.Scanner;

public class ArraySum {
	
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int intN = scanner.nextInt();
		scanner.nextLine();
		long sum = 0;
		for(int i=0;i<intN;i++) {
			sum+=(scanner.nextInt());
		}
		scanner.close();
		System.out.println(sum);
	}

}
