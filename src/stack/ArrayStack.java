package stack;

import java.util.Arrays;

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
		this.S = (E[]) new Object[this.capacity];
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

	@SuppressWarnings("unchecked")
	@Override
	public void push(E element) throws FullStackException, EmptyStackException {
		if(size() == capacity){
			this.capacity += this.capacity;
			E tempS[] = (E[]) new Object[this.capacity];
			tempS = Arrays.copyOf(this.S, this.capacity);
			this.S = null;
			this.S = (E[]) new Object[this.capacity];
			this.S = tempS;			
		}
		this.S[++top] = element;
	}
	
	public void union(Stack<E> s) throws EmptyStackException{
		@SuppressWarnings("unchecked")
		E tempS[] = (E[]) new Object[s.size()];
		int tempTop= -1;
		while(!s.isEmpety())
			tempS[++tempTop] = s.pop();
		while(tempTop > -1)
			this.S[++top] = tempS[tempTop--];
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

	@Override
	public String toString() {
		return "ArrayStack [capacity=" + capacity + ", S=" + Arrays.toString(S)
				+ ", top=" + top + "]";
	}

	

}
