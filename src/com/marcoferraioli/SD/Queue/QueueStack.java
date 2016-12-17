package com.marcoferraioli.SD.Queue;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Queue;
import com.marcoferraioli.SD.Interface.Stack;
import com.marcoferraioli.SD.Stack.StackArray;

public class QueueStack<E> implements Queue<E> {
	
	private Stack<E> Stack;
	private Stack<E> Stack2;
	private int front = 0;
	private int rear = 0;
	
	public QueueStack() {
		this.Stack = new StackArray<E>();
		this.Stack2 = new StackArray<E>();
	}

	@Override
	public void enqueue(E element) throws FullException {
		try{
			this.Stack.push(element);
		}catch(FullException e){
			throw new FullException("Coda Piena.");
		}
		
	}

	@Override
	public E dequeue() throws EmptyException {
		this.Stack2 = new StackArray<E>();
		int size = this.Stack.size();
		E element = null;
		for (int i = 0; i<size; i++){
			try {
				this.Stack2.push(this.Stack.pop());
			} catch (FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.Stack = new StackArray<E>();
		try {
			element = this.Stack2.pop();
		} catch (EmptyException e) {
			throw new EmptyException("Coda Vuota.");
		}
		size = this.Stack2.size();
		for (int i = 0; i<size; i++){
			try {
				this.Stack.push(this.Stack2.pop());
			} catch (FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return element;
	}

	@Override
	public E front() throws EmptyException {
		this.Stack2 = new StackArray<E>();
		int size = this.Stack.size();
		E element = null;
		for (int i = 0; i<size; i++){
			try {
				this.Stack2.push(this.Stack.pop());
			} catch (FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.Stack = new StackArray<E>();
		element = this.Stack2.top();
		size = this.Stack2.size();
		for (int i = 0; i<size; i++){
			try {
				this.Stack.push(this.Stack2.pop());
			} catch (FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return element;
	}

	@Override
	public int size() {
		return this.Stack.size();
	}

	@Override
	public boolean isEmpty() {
		return this.Stack.isEmpty();
	}

}
