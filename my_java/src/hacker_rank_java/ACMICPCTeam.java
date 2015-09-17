package hacker_rank_java;
import java.math.BigInteger;
//import java.util.BitSet;
import java.util.Scanner;
public class ACMICPCTeam {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nPeopleSize = scanner.nextInt();
		scanner.nextLine();
		BigInteger[] pplRep = new BigInteger[nPeopleSize];
		BigInteger bigMaxTopics = BigInteger.ZERO;
		int iMaxCount = 0;
		for(int idx=0;idx<nPeopleSize;idx++){
			pplRep[idx] = new BigInteger(scanner.nextLine(),2);
		}
		scanner.close();
		for(int iFixed = 0;iFixed<nPeopleSize;iFixed++) {
			for(int iVar=iFixed+1;iVar<nPeopleSize;iVar++){
				BigInteger orValue = pplRep[iFixed].or(pplRep[iVar]);
				//System.out.println(orValue);
				if(orValue.bitCount()==bigMaxTopics.bitCount()) {
					iMaxCount++;
				}
				if(orValue.bitCount()>bigMaxTopics.bitCount()) {
					iMaxCount = 1;
					bigMaxTopics = orValue;
				}
			}
		}
		int iBitCount = 0;
		BigInteger shiftedNumber = bigMaxTopics;
		//System.out.println("%%%%%bigMaxTopics:"+bigMaxTopics);
		while(!shiftedNumber.equals(BigInteger.ZERO)) {
			if(shiftedNumber.and(BigInteger.ONE).
					compareTo(BigInteger.ONE)==0) {				
				iBitCount++;
			}
			shiftedNumber = shiftedNumber.shiftRight(1);
		}
		System.out.println(iBitCount);
		System.out.println(iMaxCount);   
	}
}