package stack;

import exception.EmptyStackException;
import exception.FullStackException;
import node.Node;

public class NodeStack<E> implements Stack<E> {
	protected Node<E> top;
	protected int size;
	
	public NodeStack() {
		this.top = null;
		this.size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpety() {
		return (this.size<=0);
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpety())
			throw new EmptyStackException("Stack Vuoto.");
		return this.top.getElement();
	}

	@Override
	public void push(E element) throws FullStackException {
		Node<E> v = new Node<E>(element, this.top);
		this.top = v;
		this.size++;
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpety())
			throw new EmptyStackException("Stack Vuoto.");
		E temp = this.top.getElement();
		this.top = this.top.getNext();
		this.size--;
		return temp;
	}

}
