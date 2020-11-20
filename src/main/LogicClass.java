package main;

import java.util.Arrays;
import java.util.HashSet;

public class LogicClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start Of String/Array Problem Set.");
		System.out.println("Run JUnit test cases to test functionality");
	}

	public String hello() {
		return "Hello World";
	}

	//1.1  Implement an algorithm to determine if a string has all unique chars without additional data structure
	public Boolean identifyDuplicateChars(String input) {

		//First check for max number of Unique Chars. 

		for(int i = 0; i < input.length(); i++) {
			char needle = input.charAt(i);
			String subString = input.substring(i+1);
			if(subString.contains(String.valueOf(needle))) {
				return false;
			}
		}
		return true;
	}
	//1.2 This was C++ related question. I skipped

	//1.3  Given two Strings, write a method to decide if one is a permutation of the other. 
	public Boolean isPermutation(String a, String b) {
		if(a.length() == b.length()) {
			char tempArrayFirstInput[] = a.toCharArray();
			char tempArraySecondInput[] = b.toCharArray();
			Arrays.sort(tempArrayFirstInput);
			Arrays.sort(tempArraySecondInput);

			String sortedStringA = new String(tempArrayFirstInput);
			String sortedStringB = new String(tempArraySecondInput);

			if (sortedStringA.equals(sortedStringB)) {
				return true;
			}
		}

		return false;
	}

	//1.4 Write a method to replace all spaces in a string with '%20;. You may assume that the string has sufficient space at the end of the string to hold the additional chars.
	public String replaceSpaces(String input) {
		char[] inputArray = input.toCharArray();
		int totalSpaces = 0;
		for(int i =0; i < inputArray.length; i++) {
			if(inputArray[i] == ' ') {
				totalSpaces++;
			}

		}
		int trailingWhiteSpaceCount = totalSpaces - (totalSpaces / 3);
		String noTrailingSpaces = input.substring(0, (input.length() - trailingWhiteSpaceCount));
		String formattedOutput = noTrailingSpaces.replace(" ", "%20");
		return formattedOutput;
	}

	//1.5 Implement a method to perform a basic string compression using the counts of repeated characters. For example, the string aabcccccaa would become a2b1c5a3. String wont be longer then original, if so return original string
	public String countOccurences(String input) {
		// Count Occurences and replace existing 
		String last = input.substring(0, 1);
		StringBuffer formattedOutput = new StringBuffer();
		int count = 1;
		for(int i = 1; i < input.length(); i++) {
			if(last.equals(input.substring(i, i +1))) {
				count++;
			}
			else {
				formattedOutput.append(last);
				formattedOutput.append(count);
				count = 1;
				last = input.substring(i, i+1);
			}

		}
		formattedOutput.append(last);
		formattedOutput.append(count);

		if(formattedOutput.length() < input.length()) {
			return new String(formattedOutput);
		}
		else {
			return input;
		}
	}


	//1.6 given NxN array. Rotate it 90 degrees clockwise
	public String[][] rotateNinety(String[][] input, int size){

		// Consider all squares one by one 
		for (int x = 0; x < size / 2; x++) { 
			int last = size - 1 - x;
			// Consider elements in group 
			// of 4 in current square 

			for (int y = x; y < size - x - 1; y++) { 
				int offset = y - x;
				// Store current cell in 
				// temp variable 
				String temp = input[x][y]; 

				// Move values from bottom left to top left
				input[x][y] = input[last - offset][x];

				// Move values from bottom right to bottom left
				input[last - offset][x] = input[last][last - offset]; 

				// Move value from top right to bottom right
				input[last][last - offset] = input[y][last];

				// Move values temp(original top left) to top right
				input[y][last] = temp;
			} 
		} 

		return input;
	}
	//1.7 Write algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
	public int[][] zeroOutRowCol(int[][] input) {
		boolean[] row = new boolean[input.length];	
		boolean[] column = new boolean[input[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length;j++) {
				if (input[i][j] == 0) {
					row[i] = true; 
					column[j] = true;
				}
			}
		}
		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(input, i);
			}
		}
		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(input, j);
			}
		}

		return input;
	}
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}

	//1.8 Using isSubstring once how can you tell if two strings are a rotation of each other. ex: "sam" is rotation of "ams"
	public boolean validateIsSubString(String word1, String word2) {

		if((word1.length() != word2.length()) || word1.equals(word2)) {
			return false;
		}
		char[] word1Array = word1.toCharArray();
		char[] word2Array = word2.toCharArray();

		Arrays.sort(word1Array);
		Arrays.sort(word2Array);
		word1 = new String(word1Array);
		word2 = new String(word2Array);

		if(isSubstring(word1, word2)){
			return true;
		}
		return false;
	}

	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}


}
