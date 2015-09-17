package hacker_rank_java;
import java.util.Scanner;

public class CavityMap {

	public static void printCavityMap(int[][] matrix, int n) {
		for(int iRowIdx=0;iRowIdx<n;iRowIdx++) {
			for(int iColIdx=0;iColIdx<n;iColIdx++) {
				if(iRowIdx==0 || iColIdx==0 || 
				   iRowIdx==n-1 || iColIdx==n-1) {
					System.out.print(matrix[iRowIdx][iColIdx]);
				} else {
					int value = matrix[iRowIdx][iColIdx];
					// check for cavity
					int upValue = matrix[iRowIdx-1][iColIdx];
					if(upValue < value) {
						int downValue = matrix[iRowIdx+1][iColIdx];
						if(downValue < value) {
							int leftValue = matrix[iRowIdx][iColIdx-1];
							if(leftValue < value) {
								int iRightValue = matrix[iRowIdx][iColIdx+1];
								if(iRightValue < value) {
									System.out.print('X');
								} else {
									System.out.print(matrix[iRowIdx][iColIdx]);
								}
							} else {
								System.out.print(matrix[iRowIdx][iColIdx]);
							}
						} else {
							System.out.print(matrix[iRowIdx][iColIdx]);
						}
					} else {
						System.out.print(matrix[iRowIdx][iColIdx]);
					}
				}
			}
			System.out.print("\n");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nLines = scanner.nextInt();
		scanner.nextLine();
		int[][] iMatrix = new int[nLines][nLines];
		for(int iLineIdx=0;iLineIdx<nLines;iLineIdx++) {
			String strLine = scanner.nextLine();
			for(int colIdx = 0;colIdx<nLines;colIdx++) {
				iMatrix[iLineIdx][colIdx] = Integer.parseInt(strLine.charAt(colIdx)+"");
			}
		}
		scanner.close();
		printCavityMap(iMatrix,nLines);
	}

}
