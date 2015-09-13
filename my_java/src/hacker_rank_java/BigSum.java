package hacker_rank_java;
import java.util.Scanner;
import java.math.BigDecimal;
public class BigSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigDecimal bigSum = BigDecimal.ZERO;
        for(int idx=0;idx<N;idx++) {
        	bigSum = (new BigDecimal(scanner.next())).add(bigSum);
        }
        scanner.close();
        System.out.println(bigSum.toPlainString());
	}

}
