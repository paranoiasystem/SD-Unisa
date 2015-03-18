package stack;

import exception.EmptyStackException;
import exception.FullStackException;

public class ArrayStack<E> implements Stack<E>{
	
	protected int capacity;
	protected static final int CAPACITY = 1000;
	protected E S[];
	protected int top = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity){
		this.capacity = capacity;
		S = (E[]) new Object[this.capacity];
	}
	
	public ArrayStack(){
		this(CAPACITY);
	}

	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpety() {
		return (this.top < 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpety())
			throw new EmptyStackException("Stack Vuoto.");
		return this.S[top];
	}

	@Override
	public void push(E element) throws FullStackException {
		if(size() == capacity)
			throw new FullStackException("Stack Pieno.");
		this.S[++top] = element;
	}

	@Override
	public E pop() throws EmptyStackException {
		E element;
		if(isEmpety())
			throw new EmptyStackException("Stack Vuoto.");
		element = S[top];
		this.S[top--] = null;
		return element;
	}

}
