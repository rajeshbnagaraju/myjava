package hacker_rank_java;
import java.util.Scanner;
public class SherlockAndTheBeast {
	
	private static String getValue(int digit1,int num1,int digit2,int num2) {
		//String str = null;
		String repeated1 = num1==0?"":new String(new char[num1]).replaceAll("\0", digit1+"");
		String repeated2 = num2==0?"":new String(new char[num2]).replaceAll("\0", digit2+"");
		return repeated1+repeated2;
	}
	
	public static String getMaxDecentNumber(int num) {
		String iValue = -1+"";	
		if(num < 3) {
			return -1+"";
		} else {
			int remainder3 = num%3;
			if(remainder3==0) {
				return getValue(5,num,3,0);
			}
			//int remainder5 = num%5;
			//if(remainder5==0){
			//	return getValue(5,0,3,num);
			//}
			if(remainder3==2){
				int newNum = num - 5;
				return getValue(5,newNum,3,5);
			}
			if(remainder3==1 && num>=10){
				int newNum = num -10;
				return getValue(5,newNum,3,10);
			}
		}
		return iValue;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int iTestCases = scanner.nextInt();
		String[] strOutputs = new String[iTestCases];
		for(int i=0;i<iTestCases;i++) {
			scanner.nextLine();
			int num = scanner.nextInt();
			strOutputs[i] = getMaxDecentNumber(num);
		}
		for(String output:strOutputs) {
			System.out.println(output);
		}
		scanner.close();
	}

}
