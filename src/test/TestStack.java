package test;

import exception.EmptyStackException;
import exception.FullStackException;
import stack.ArrayStack;
import stack.Stack;

public class TestStack {
	public static String invert(String word) throws FullStackException, EmptyStackException{
		Stack<Character> S = new ArrayStack<Character>();
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
	public static boolean isBalanced(String s) throws FullStackException, EmptyStackException{
		Stack<Character> S = new ArrayStack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				S.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
				if(S.isEmpety())
					return false;
				else
					S.pop();
			}
		}
		if(S.isEmpety())
			return true;
		else 
			return false;
	}
	public static void main(String[] args) throws FullStackException, EmptyStackException{
		System.out.println(invert("radar"));
		System.out.println(isPalindrome(invert("radar")));	
		System.out.println(isBalanced("{([f(g)])}"));
	}
}
