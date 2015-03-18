package test;

import exception.EmptyStackException;
import exception.FullStackException;
import stack.NodeStack;
import stack.Stack;

public class TestStackNode {
	public static String invert(String word) throws FullStackException, EmptyStackException{
		Stack<Character> S = new NodeStack<Character>();
		int length = word.length();
		String worldToReturn = "";
		for (int i = 0; i < length; i++)
			S.push(word.charAt(i));
		while(!S.isEmpety())
			worldToReturn += S.pop();
		return worldToReturn;
	}
	public static boolean isPalindrome(String word) throws FullStackException, EmptyStackException {
		word = word.replace(" ", "");
		return (word.equals(invert(word)));
		
	}
	public static boolean isBalanced(String s){
		return false;
	}
	public static void main(String[] args) throws FullStackException, EmptyStackException{
		System.out.println(invert("radar"));
		System.out.println(isPalindrome(invert("radar")));		
	}
}
