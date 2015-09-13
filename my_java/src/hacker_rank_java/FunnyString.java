package hacker_rank_java;
import java.util.Scanner;
public class FunnyString {
	  public String checkFunnyString(String str) {
		  int iFWDPtr = 1;
		  int iRevPtr= str.length()-1;
		  //boolean funnString = true;
		  while(iFWDPtr<iRevPtr) {
			  int iFWDVal = Math.abs((int)str.charAt(iFWDPtr)-(int)str.charAt(iFWDPtr-1));
			  int iRevVal = Math.abs((int)str.charAt(iRevPtr)-(int)str.charAt(iRevPtr-1));
			  if(iFWDVal!=iRevVal) {
				  return "Not Funny";
			  }
			  iFWDPtr++;
			  iRevPtr--;
		  }
		  return "Funny";
	  }
      public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);
    	  int iTestCases = Integer.parseInt(scanner.nextLine());
    	  String[] strOutput = new String[iTestCases];
    	  FunnyString funnyString = new FunnyString();
    	  for(int iCurrTC=0;iCurrTC<iTestCases;iCurrTC++) {
    		  strOutput[iCurrTC]=funnyString.checkFunnyString(scanner.nextLine());
    	  }
    	  scanner.close();
    	  for(String out:strOutput){
    		  System.out.println(out);
    	  }
      }
}
