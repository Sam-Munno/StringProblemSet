package test;


import org.junit.Test;

import main.LogicClass;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestJunit {
	


@Test
public void testPrintMessage() {
	LogicClass mainFile = new LogicClass();
   //Equals
	assertEquals("Hello World", mainFile.hello());
	assertEquals("Hello World", mainFile.hello());
   
   //NotEquals
   assertNotEquals("jell", mainFile.hello());
   assertNotEquals("Hello Worl", mainFile.hello());
   
}
//1.1  Implement an algorithm to determine if a string has all unique chars without additional data structure
@Test public void allUniqueChars() {
	LogicClass mainFile = new LogicClass();
	String input1 = "sammas";
	String input2 = "sam";
	
	//Equals
	assertEquals(true, mainFile.identifyDuplicateChars(input2));
	
	//NotEquals
	assertEquals(false, mainFile.identifyDuplicateChars(input1));
}

//1.3  Given two Strings, write a method to decide if one is a permutation of the other. 
@Test public void isPermutation() {
	LogicClass mainFile = new LogicClass();
	
	String input1 = "asm";
	String input2 = "sam";
	
	String input3 = "sam";
	String input4 = "samtheman";
	
	String input5 = "super";
	String input6 = "uperf";
	
	//Equals
	assertEquals(true, mainFile.isPermutation(input1, input2));
	
	//NotEquals
	assertEquals(false, mainFile.isPermutation(input3, input4));
	assertEquals(false, mainFile.isPermutation(input5, input6));
}

//1.4 Write a method to replace all spaces in a string with '%20;. You may assume that the string has sufficient space at the end of the string to hold the additional chars. Use Char Array. 
@Test public void replaceAllSpaces() {
	LogicClass mainFile = new LogicClass();
	
	String input1 = "Mr John Smith    ";
	String output1 ="Mr%20John%20Smith";
	
	assertEquals(output1, mainFile.replaceSpaces(input1));
	
	
}

//1.5 Implement a method to perform a basic string compression using the counts of repeated characters. For example, the string aabcccccaa would become a2b1c5a3. String wont be longer then original, if so return original string
@Test public void countOccurences() {
	LogicClass mainFile = new LogicClass();
	String input = "aabcccccaa";
	String output = "a2b1c5a2";
	
	String input2 = "aabcaa";
	
	assertEquals(output, mainFile.countOccurences(input));
	
	assertEquals(input2, mainFile.countOccurences(input2));
	
	
}
//1.6 given NxN array. Rotate it 90 degrees clockwise
@Test public void rotateNinety() {
	LogicClass mainFile = new LogicClass();
	String[][] input = {{"a","b","c","d"},
						{"a","b","c","d"},
						{"a","b","c","d"},
						{"a","b","c","d"}
						};
	
	String[][] output = {{"a","a","a","a"},
						{"b","b","b","b"},
						{"c","c","c","c"},
						{"d","d","d","d"}
						};

	assertArrayEquals(output, mainFile.rotateNinety(input, 4));
}

//1.7 Write algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
@Test public void zeroOutRowCol() {
	LogicClass mainFile = new LogicClass();
		int[][] input = {{1,0,3,5,4},
						 {1,2,3,5,4},
						 {1,0,3,5,4},
						 {1,7,3,5,4}
						};
		
		int[][] output = {{0,0,0,0,0},
				 		  {1,0,3,5,4},
				 		  {0,0,0,0,0},
				 		  {1,0,3,5,4}
				};
		assertArrayEquals(output, mainFile.zeroOutRowCol(input));
		
		
 	}

//1.8 Using isSubstring once how can you tell if two strings are a rotation of each other. ex: "sam" is rotation of "ams"
@Test public void isSubstring() {
	LogicClass mainFile = new LogicClass();
	String word1 = "waterbottle";
	String word2 = "erbottlewat";
	
	String word3 = "wasarbottle";
	String word4 = "erbottlewat";
	
	
	assertEquals(true, mainFile.validateIsSubString(word1, word2));
	assertEquals(false, mainFile.validateIsSubString(word3, word4));
}


}