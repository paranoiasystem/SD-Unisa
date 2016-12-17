package com.marcoferraioli.SD.Interface;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;

public interface Stack<E> {
	public int size();
	public boolean isEmpty();
	public E top() throws EmptyException;
	public void push (E element) throws FullException;
	public E pop() throws EmptyException;
}
