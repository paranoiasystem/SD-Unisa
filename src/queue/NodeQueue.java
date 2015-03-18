package queue;

import node.Node;
import exception.EmptyQueueException;

public class NodeQueue<E> implements Queue<E> {
	
	protected Node<E> head, tail;
	protected int size;
	
	public NodeQueue() {
		head = null;
		tail  = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}

	@Override
	public E front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(size == 0)
			throw new EmptyQueueException("Coda Vuota.");
		E tmp = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return tmp;
	}
	
	public String toString(){
		String s ="";
		s += "(";
		if(!isEmpty()){
			Node<E> p = head;
			do{
				s += (String) p.getElement();
				if(p != tail)
					s += ", ";
				p = p.getNext();
			}while(p != null);
		}
		s += ")";
		return s;
	}

}
