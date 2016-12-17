package com.marcoferraioli.SD.Stack;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Stack;

public class StackArray<E> implements Stack{
	
	private static final int MAXSIZE = 10;
	private E Stack[];
	private int top = -1;
	
	public StackArray(){
		this.Stack = (E[]) new Object[this.MAXSIZE];
	}

	@Override
	public int size() {
		return this.top + 1;
	}

	@Override
	public boolean isEmpty() {
		return (this.top < 0);
	}

	@Override
	public Object top() throws EmptyException {
		if(this.isEmpty()){
			throw new EmptyException("Stack Vuoto.");
		}
		return this.Stack[this.top];
	}

	@Override
	public void push(Object element) throws FullException {
		if(this.size() == this.MAXSIZE){
			throw new FullException("Stack Pieno.");
		}
		this.Stack[++this.top] = (E) element;
	}

	@Override
	public Object pop() throws EmptyException {
		if(this.isEmpty()) {
			throw new EmptyException("Stack Vuoto");
		}
		E element = this.Stack[this.top];
		this.Stack[this.top--] = null;
		return element;
	}
}
