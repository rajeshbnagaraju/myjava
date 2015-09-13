package hacker_rank_java;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SquareDigitChains {

	Set<Long> map89 = new HashSet<Long>();
	Set<Long> map1 = new HashSet<Long>();
	public static final BigDecimal bigOne = BigDecimal.ONE;

	public void init() {
		// set some default values to the tree
		map1.add(1L);
		map89.add(89L);
	}
	
	public int[] getDigitArray(String strNumber) {
		// need 10 as the last index is 9
		int[] digitArray = new int[10];
		int iStrLen = strNumber.length();
		int iLeftIndex = 0;
		int iRightIndex = iStrLen - 1;
		int iMiddleIndex = (int) Math.ceil(iStrLen / 2);
		char[] charArray = strNumber.toCharArray();
		// build the digit Array
		while (iLeftIndex <= iMiddleIndex) {
			// if there are odd numbers we dont want to double count the middle
			// digit
			if (iLeftIndex == iMiddleIndex) {
				int iDigit = Integer.parseInt(charArray[iRightIndex] + "");
				digitArray[iDigit] = digitArray[iDigit] + 1;
				break;
			} else {
				int iLeftDigit = Integer.parseInt(charArray[iLeftIndex] + "");
				digitArray[iLeftDigit] = digitArray[iLeftDigit] + 1;
				iLeftIndex++;
				if (iRightIndex != iMiddleIndex) {
					int iRightDigit = Integer.parseInt(charArray[iRightIndex]
							+ "");
					digitArray[iRightDigit] = digitArray[iRightDigit] + 1;
					iRightIndex--;
				}
			}
		}
		return digitArray;
	}
	
	public String convertArrayToString(int[] digitSumArray) {
		StringBuilder buildSumStr = new StringBuilder();
		buildSumStr.append("11111111111111111111".substring(0, digitSumArray[1]));
		buildSumStr.append("22222222222222222222".substring(0, digitSumArray[2]));
		buildSumStr.append("33333333333333333333".substring(0, digitSumArray[3]));
		buildSumStr.append("44444444444444444444".substring(0, digitSumArray[4]));
		buildSumStr.append("55555555555555555555".substring(0, digitSumArray[5]));
		buildSumStr.append("66666666666666666666".substring(0, digitSumArray[6]));
		buildSumStr.append("77777777777777777777".substring(0, digitSumArray[7]));
		buildSumStr.append("88888888888888888888".substring(0, digitSumArray[8]));
		buildSumStr.append("99999999999999999999".substring(0, digitSumArray[9]));
		return buildSumStr.toString();
	}

	public String getDigitSquareSum(String strNumber) {		
		int[] digitArray = getDigitArray(strNumber);
		String strSum = (digitArray[1] + digitArray[2] * 4 + digitArray[3] * 9
				+ digitArray[4] * 16 + digitArray[5] * 25 + digitArray[6] * 36
				+ digitArray[7] * 49 + digitArray[8] * 64 + digitArray[9] * 81)+""; 
		int[] digitSumArray = getDigitArray(strSum);
	    strSum = convertArrayToString(digitSumArray);
		return strSum;

	}

	public boolean isSquareDigitChainOf89(BigDecimal value) {
		String strValue = value.toPlainString();
		String strValueWithOutZeros = strValue.replaceAll("0", "");
        
		if (map89.contains(new Long(strValueWithOutZeros))) {
			return true;
		}
		

		String strSquareDigitSum = getDigitSquareSum(strValueWithOutZeros).replaceAll("0", "");
		// search in the tree after replacing 0s in addition to the ones without
		// 0s
		if (map89.contains(new Long(strSquareDigitSum))) {
			map89.add(new Long(strValueWithOutZeros));
			return true;
		}
		if (map1.contains(new Long(strSquareDigitSum) )) {
			map1.add(new Long(strValueWithOutZeros));
			return false;
		} else {
			return isSquareDigitChainOf89(new BigDecimal(strSquareDigitSum));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String strLimit = scanner.nextLine();
		scanner.close();
		SquareDigitChains squareDigitChains = new SquareDigitChains();
		squareDigitChains.init();
		BigDecimal bigFinalIndex = new BigDecimal(strLimit);
		BigDecimal bigCurrentIndex = BigDecimal.ONE;
		BigDecimal totalValues = BigDecimal.ZERO;
		long startTime = System.currentTimeMillis();
		while (bigCurrentIndex.compareTo(bigFinalIndex) == -1) {
			bigCurrentIndex = bigCurrentIndex.add(bigOne);
			if (squareDigitChains.isSquareDigitChainOf89(bigCurrentIndex)) {
				totalValues = totalValues.add(bigOne);
			}
		}
		long dr =  (long)Math.pow(10.0, 9.0);
		
		long iLongTotal = (totalValues.longValue()/dr) + 7;
		long endTime = System.currentTimeMillis();
		System.out.println(totalValues.longValue());
		System.out.println(iLongTotal);
		System.out.println("***time:" + ((endTime - startTime) / 1000));
	}
}
