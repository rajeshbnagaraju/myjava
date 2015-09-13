package hacker_rank_java;
import java.util.Scanner;
public class DiagonalDifference {
	int iRows = 0;
	public long diagonalDiff(int[][] matrix){
		int iFwdSum = 0;
		int iRevSum = 0;
		for(int iFwdRowIndex = 0,iRevColIndex = iRows-1;iFwdRowIndex<iRows;iFwdRowIndex++,iRevColIndex--){
			iFwdSum+=matrix[iFwdRowIndex][iFwdRowIndex];
			iRevSum+=matrix[iFwdRowIndex][iRevColIndex];
			//System.out.println("iFwdSum:"+iFwdSum);
			//System.out.println("iRevSum:"+iRevSum);
		}
		//System.out.println(iFwdSum+"-"+iRevSum+"::iRows:"+iRows);
		return Math.abs(iFwdSum-iRevSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        DiagonalDifference diagonalDifference = new DiagonalDifference();
        diagonalDifference.iRows=N;
        //System.out.println("iRows:"+diagonalDifference.iRows);
        int matrix[][] = new int[N][N];
        for(int iLine =0 ; iLine < N;iLine++) {
        	String strline = scanner.nextLine();
        	String[] strLineToks = strline.split(" ");
        	int iTokLen = strLineToks.length;
        	for(int iTokIndex=0;iTokIndex<iTokLen;iTokIndex++) {
        		matrix[iLine][iTokIndex]=Integer.parseInt(strLineToks[iTokIndex]);
        	}
        }
        scanner.close();
        System.out.println(diagonalDifference.diagonalDiff(matrix));
	}

}
