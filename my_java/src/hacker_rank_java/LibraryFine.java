package hacker_rank_java;
import java.util.Scanner;
public class LibraryFine {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int actDay = scanner.nextInt();
		int actMonth = scanner.nextInt();
		int actYear = scanner.nextInt();
		scanner.nextLine();
		int expDay = scanner.nextInt();
		int expMonth = scanner.nextInt();
		int expYear = scanner.nextInt();
		if(actYear>expYear) {
			System.out.println(10000);
		} else if (actMonth > expMonth && actYear==expYear) {
			int iFine = 500*(actMonth - expMonth);
			System.out.println(iFine);
		} else if(actDay>expDay && actMonth==expMonth) {
			int iFine = 15*(actDay - expDay);
			System.out.println(iFine);
		} else {
			System.out.println(0);
		}
		scanner.close();
		
	}
	
}
