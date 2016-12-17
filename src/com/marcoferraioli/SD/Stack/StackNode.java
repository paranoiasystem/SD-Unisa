package com.marcoferraioli.SD.Stack;

import com.ferraiolimarco.SD.LinkedList.Node;
import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Interface.Stack;

public class StackNode<E> implements Stack<E>{
	
	private Node<E> top;
	private int size;
	
	public StackNode() {
		this.top = new Node<E>();
		this.size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		return false;
	}

	@Override
	public E top() throws EmptyException {
		if (isEmpty()) 
			throw new EmptyException("Stack vuoto.");
		return top.getElement();
	}

	@Override
	public void push(E element) throws FullException {
		try {
			Node<E> v = new Node<E>(element,top);
			} catch (Exception e){
				throw new FullException("Stack pieno");
			}
		top = v;
		size++;		
	}

	@Override
	public E pop() throws EmptyException {
		if (isEmpty()) 
			throw new EmptyException("Stack vuoto.");
		E temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}

}
