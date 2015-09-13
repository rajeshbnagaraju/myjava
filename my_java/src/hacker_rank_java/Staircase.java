package hacker_rank_java;
import java.util.Scanner;
public class Staircase {
	
    public static String lpad(int iSize,StringBuilder strBuild) {
    	StringBuilder strSpaceBuild = new StringBuilder("");
    	int iLimit = iSize - strBuild.length();
    	for(int i=0;i<iLimit;i++) {
    		strSpaceBuild.append(" ");
    	}
    	return strSpaceBuild.append(strBuild.toString()).toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		scanner.close();
		StringBuilder strBuild = new StringBuilder();
		for(int i=0;i<N;i++) {
			strBuild.append("#");
			System.out.println(lpad(N,strBuild));
		}
	}

}
