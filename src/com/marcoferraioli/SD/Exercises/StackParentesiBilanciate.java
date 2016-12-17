package com.marcoferraioli.SD.Exercises;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Stack;
import com.marcoferraioli.SD.Stack.StackArray;

public class StackParentesiBilanciate {
	
	public static boolean isBalanced(String s) throws FullException, EmptyException{
		Stack<Character> S = new StackArray<Character>();
		boolean state = true;
		int length = s.length();
		for (int i=0 ; i<length ; i++){
			Character c = s.charAt(i);
			if(c.equals('{') || c.equals('[') || c.equals('(')){
				S.push(c);
			} else if (c.equals('}') || c.equals(']') || c.equals(')'))	{
				if(S.top().equals('{') && c.equals('}')){
					state = true;
					S.pop();
				} else if (S.top().equals('[') && c.equals(']')){
					state = true;
					S.pop();
				} else if (S.top().equals('(') && c.equals(')')){
					state = true;
					S.pop();
				} else {
					state = false;
					break;
				}
			}
		}
		return state;
	}

	public static void main(String[] args) throws FullException, EmptyException {
		System.out.println(isBalanced("({hilo}kkkk)[jio]"));
	}

}
