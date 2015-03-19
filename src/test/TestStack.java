package test;

import exception.EmptyStackException;
import exception.FullStackException;
import stack.ArrayStack;
import stack.Stack;

public class TestStack {
	public static String invert(String word) throws FullStackException, EmptyStackException{
		Stack<Character> S = new ArrayStack<Character>(3);
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
		Stack<Character> S = new ArrayStack<Character>(3);
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
	public static Stack<Character> testUnion(String s, String s1) throws FullStackException, EmptyStackException{
		Stack<Character> S = new ArrayStack<>();
		Stack<Character> S1 = new ArrayStack<>();
		int length = s.length();
		for (int i = 0; i < length; i++)
			S.push(s.charAt(i));
		length = s1.length();
		for (int i = 0; i < length; i++)
			S1.push(s1.charAt(i));
		((ArrayStack<Character>) S).union(S1);
		return S;
	}
	public static void main(String[] args) throws FullStackException, EmptyStackException{
		System.out.println(invert("radar"));
		System.out.println(isPalindrome(invert("radar")));	
		System.out.println(isBalanced("{([f(g)])}"));
		System.out.println(testUnion("an","na"));
	}
}
