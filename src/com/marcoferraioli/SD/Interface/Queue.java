package com.marcoferraioli.SD.Interface;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;

public interface Queue<E> {
	public void enqueue(E element) throws FullException;
	public E dequeue() throws EmptyException;
	public E front() throws EmptyException;
	public int size();
	public boolean isEmpty();
}
