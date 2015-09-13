package hacker_rank_java;

import java.util.Scanner;


public class EndOfFile {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		StringBuilder input = new StringBuilder();
		int i = 1;
		while (scanner.hasNext()) {
			input.append(i + " " + scanner.nextLine()+"\n");
			i++;
			//System.out.println("***"+i);
		}
		System.out.println(input.toString());
		scanner.close();
	}
}