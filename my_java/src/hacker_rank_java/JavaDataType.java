package hacker_rank_java;

//import java.io.*;
import java.util.*;
//import java.text.*;
import java.math.*;
//import java.util.regex.*;

public class JavaDataType {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int iSize = scanner.nextInt();
        BigDecimal[] iArr = new BigDecimal[iSize];
        String[] opStrings = new String[iSize];
        BigDecimal byteMax = new BigDecimal(Byte.MAX_VALUE);
        BigDecimal shortMax = new BigDecimal(Short.MAX_VALUE);
        BigDecimal intMax = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal longMax = new BigDecimal(Long.MAX_VALUE);
        BigDecimal byteMin = new BigDecimal(Byte.MIN_VALUE);
        BigDecimal shortMin = new BigDecimal(Short.MIN_VALUE);
        BigDecimal intMin = new BigDecimal(Integer.MIN_VALUE);
        BigDecimal longMin = new BigDecimal(Long.MIN_VALUE);
        for(int i=0;i<iSize;i++) {
            scanner.nextLine();
            iArr[i]=scanner.nextBigDecimal();
            StringBuilder strBuild = null;
            if(iArr[i].compareTo(byteMax) <= 0 && iArr[i].compareTo(byteMin) >= 0) {
            	//StringBuilder strBuild = null;
                strBuild=new StringBuilder(iArr[i] + " can be fitted in:");
                strBuild.append("\n"+"* byte");
            } 
            if(iArr[i].compareTo(shortMax) <= 0 && iArr[i].compareTo(shortMin) >= 0) {
                if(strBuild==null) {
                    strBuild=new StringBuilder(iArr[i] + " can be fitted in:");
                }
                strBuild.append("\n"+"* short");
            } 
            if(iArr[i].compareTo(intMax) <= 0  && iArr[i].compareTo(intMin) >= 0){
                if(strBuild==null) {
                    strBuild=new StringBuilder(iArr[i] + " can be fitted in:");
                }
                strBuild.append("\n"+"* int");
            } 
            if(iArr[i].compareTo(longMax) <= 0  && iArr[i].compareTo(longMin) >= 0) {
                if(strBuild==null) {
                    strBuild=new StringBuilder(iArr[i] + " can be fitted in:");
                }
                strBuild.append("\n"+"* long");
            } 
            else {
                if(strBuild==null) {
                    strBuild=new StringBuilder(iArr[i] + " can't be fitted anywhere.");
                }
            }
            opStrings[i]=strBuild.toString();
        }
        scanner.close();
        for(String str:opStrings) {
            System.out.println(str);
        }
    }
}