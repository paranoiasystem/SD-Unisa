package stack;

import exception.EmptyStackException;
import exception.FullStackException;

public interface Stack<E>{
	public int size();
	public boolean isEmpety();
	public E top() throws EmptyStackException;
	public void push(E element) throws FullStackException, EmptyStackException;
	public E pop() throws EmptyStackException;
}
