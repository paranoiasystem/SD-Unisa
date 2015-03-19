package queue;

import exception.EmptyQueueException;
import exception.FullQueueException;

public class ArrayQueue<E> implements Queue<E> {

	protected int capacity;
	public static final int CAPACITY = 1024;
	protected E Q[];
	protected int front;
	protected int rear;
	
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.Q = (E[]) new Object[this.capacity]; 
	}
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@Override
	public int size() {
		return (this.capacity - this.front + this.rear) % this.capacity;
	}

	@Override
	public boolean isEmpty() {
		return (this.front == this.rear);
	}

	@Override
	public E front() throws EmptyQueueException {
		if(this.isEmpty())
			throw new EmptyQueueException("Coda vuota.");
		return this.Q[this.front];
	}

	@Override
	public void enqueue(E element) throws FullQueueException {
		if(this.size() == capacity -1)
			throw new FullQueueException("Coda piena.");
		this.Q[this.rear] = element;
		this.rear = (this.rear + 1) % this.capacity;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		E element;
		if(this.isEmpty())
			throw new EmptyQueueException("Coda vuota.");
		element = this.Q[this.front];
		this.Q[this.front] = null;
		this.front = (this.front + 1) % this.capacity;
		return element;
	}

}
