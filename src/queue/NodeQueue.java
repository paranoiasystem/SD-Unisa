package queue;

import node.Node;
import exception.EmptyQueueException;
import exception.FullQueueException;

public class NodeQueue<E> implements Queue<E> {
	
	protected Node<E> head, tail;
	protected int size;
	
	public NodeQueue() {
		this.head = null;
		this.tail  = null;
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
		else
			return false;
	}

	@Override
	public E front() throws EmptyQueueException {
			if(this.size == 0)
				throw new EmptyQueueException("Coda vuota.");
			return this.head.getElement();
	}

	@Override
	public void enqueue(E element) throws FullQueueException {
		if(size() == this.size - 1)
			throw new FullQueueException("Coda Piena.");
		Node<E> node = new Node<E>();
		node.setElement(element);
		node.setNext(null);
		if(size() == 0)
			this.head = node;
		else
			this.tail.setNext(node);
		this.tail = node;
		this.size++;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(size == 0)
			throw new EmptyQueueException("Coda Vuota.");
		E tmp = head.getElement();
		this.head = head.getNext();
		this.size--;
		if(this.size == 0)
			this.tail = null;
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
