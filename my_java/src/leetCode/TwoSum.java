package leetCode;

//import java.util.Scanner;
public class TwoSum {
	
	/*private int[]  merge(int[] left, int[] right) {
		int iLeftLen = left.length;
		int iRightLen = right.length;
		int iLen = iLeftLen+iRightLen;
		int[] iArr = new int[iLen];
		for(int iLeftdx,idx,rightIndex=0;idx<iLen;idx++) {
			if(iArr[]) {
				
			}
		}
	}
	private int[] sort(int[] arr) {
		int iMid = arr.length
		
	}*/

	public int[] twoSum(int[] nums, int target) {
		int fixedLast = nums.length - 1;
		int output[] = new int[2];
		for (int fixed = 0; fixed < fixedLast; fixed++) {
			for (int var = fixed + 1; var < nums.length; var++) {
				if (nums[fixed] + nums[var] == target) {
					output[0] = fixed + 1;
					output[1] = var + 1;
					return output;
				}
			}
		}
		return output;
	}

	public int[] twoBFSum(int[] nums, int target) {
		int fixedLast = nums.length - 1;
		int output[] = new int[2];
		for (int fixed = 0; fixed < fixedLast; fixed++) {
			for (int var = fixed + 1; var < nums.length; var++) {
				if (nums[fixed] + nums[var] == target) {
					output[0] = fixed + 1;
					output[1] = var + 1;
					return output;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner scanner = new Scanner(System.in);
		// scanner.
		int[] iArr = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] iSol = new TwoSum().twoBFSum(iArr, target);
		System.out.println("index1:" + iSol[0] + "::index2:" + iSol[1]);
	}

}
