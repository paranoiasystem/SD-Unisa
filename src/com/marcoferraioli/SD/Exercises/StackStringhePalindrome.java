package com.marcoferraioli.SD.Exercises;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Stack;
import com.marcoferraioli.SD.Stack.StackArray;

public class StackStringhePalindrome {

	public static String invert (String word) throws FullException, EmptyException{ 
		Stack<Character> S = new StackArray<Character>(); 
		int length = word.length();
		String wordToReturn = "";
		for (int i=0 ; i<length ; i++)
			S.push(word.charAt(i));
		while (!S.isEmpty())
			wordToReturn += S.pop();
		return wordToReturn;
	}
	
	public static boolean isPalindrome(String word) throws FullException, EmptyException{
	        word = word.replaceAll(" ", "");
	        return (word.equals(invert(word)));
	}
	
	public static void main(String[] args) throws FullException, EmptyException {
		System.out.println(isPalindrome("i topi non avevano nipoti"));
	}

}
