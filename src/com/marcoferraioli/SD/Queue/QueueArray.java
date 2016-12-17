package com.marcoferraioli.SD.Queue;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Queue;

public class QueueArray<E> implements Queue<E> {
	
	private static final int MAXSIZE = 11; //In realtà MAXSIZE - 1
	private E Queue[];
	private int front = 0;
	private int rear = 0;
	
	public QueueArray(){
		this.Queue = (E[]) new Object[this.MAXSIZE];
	}
	
	@Override
	public void enqueue(E element) throws FullException {
		if(this.size() == (this.MAXSIZE - 1)){
			throw new FullException("Coda Piena.");
		}
		this.Queue[this.rear] = element;
		this.rear = (this.rear + 1)  % this.MAXSIZE;
	}

	@Override
	public E dequeue() throws EmptyException {
		if(this.isEmpty()){
			throw new EmptyException("Coda Vuota.");
		}
		E element = this.Queue[this.front];
		this.Queue[this.front] = null;
		this.front = (this.front + 1) % this.MAXSIZE;
		return element;
	}

	@Override
	public E front() throws EmptyException {
		if(this.isEmpty()){
			throw new EmptyException("Coda Vuota.");
		}
		return this.Queue[this.front];
	}

	@Override
	public int size() {
		return (this.MAXSIZE + this.rear - this.front) % this.MAXSIZE;
	}

	@Override
	public boolean isEmpty() {
		return (this.front == this.rear);
	}

}
