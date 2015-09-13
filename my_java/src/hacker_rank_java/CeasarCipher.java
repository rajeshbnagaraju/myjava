package hacker_rank_java;
/*
90
!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U
62

Output
!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E
!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E
*/
import java.util.Scanner;

public class CeasarCipher {
	
	final static int iMinSmallLetterRange = (int) 'a';
	final static int iMaxSmallLetterRange = (int) 'z';
	final static int iMinCapLetterRange = (int) 'A';
	final static int iMaxCapLetterRange = (int) 'Z';
	
	public static int getNextChar(int iCh, int iK) {
		int iNewCh = (int)iCh;
		if (iCh >= iMinSmallLetterRange && iCh <= iMaxSmallLetterRange) {
			iNewCh = iCh + iK%26;
			if (iNewCh > iMaxSmallLetterRange) {
				// need a -1 as min small letter covers 'a' 
				iNewCh = iMinSmallLetterRange + (iNewCh - iMaxSmallLetterRange) - 1;
			}
		}
		else if (iCh >= iMinCapLetterRange && iCh <= iMaxCapLetterRange) {
			iNewCh = iCh + iK%26;
			if (iNewCh > iMaxCapLetterRange) {
				iNewCh = iMinCapLetterRange + (iNewCh - iMaxCapLetterRange) -1;
			}
		} 
		return iNewCh;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nChars = scanner.nextInt();
		char[] charArray = new char[nChars];
		scanner.nextLine();
		String strLine = scanner.nextLine();
		int iK = scanner.nextInt();
		scanner.close();
		for (int idx = 0; idx < nChars; idx++) {
			int iCh = (int) strLine.charAt(idx);
			charArray[idx]=(char)getNextChar(iCh,iK);
		}
		System.out.println(new String(charArray));
	}
}
