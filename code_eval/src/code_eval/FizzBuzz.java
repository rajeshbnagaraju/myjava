package code_eval;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {

	public void readFile(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
				System.out.println(getFizzBuzz(line) + "\n");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.getMessage();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getFizzBuzz(String strLine) {
		String[] strTokens = strLine.split(" ");
		int firstParam = Integer.parseInt(strTokens[0]);
		int secondParam = Integer.parseInt(strTokens[1]);
		int thirdParam = Integer.parseInt(strTokens[2]);
		StringBuilder strBuild = new StringBuilder();
		int fIndex = firstParam;
		int bIndex = secondParam;
		for (int idx = 1; idx <= thirdParam; idx++) {
			if (idx == fIndex && idx == bIndex) {
				strBuild.append("F B ");
				fIndex += firstParam;
				bIndex += secondParam;
			} else if (idx == fIndex) {
				strBuild.append("F ");
				fIndex += firstParam;
			} else if (idx == bIndex) {
				strBuild.append("B ");
				bIndex += secondParam;
			} else {
				strBuild.append(idx + " ");
			}
		}
		return strBuild.toString().replace("F", "fizz").replace("B", "buzz")
				.trim();
	}

	public static void main(String args[]) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		fizzBuzz.readFile(args[0]);
	}
}
