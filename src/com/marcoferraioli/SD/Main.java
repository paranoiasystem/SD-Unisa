package com.marcoferraioli.SD;

import com.marcoferraioli.SD.Exception.EmptyException;
import com.marcoferraioli.SD.Exception.FullException;
import com.marcoferraioli.SD.Queue.QueueArray;
import com.marcoferraioli.SD.Queue.QueueStack;
import com.marcoferraioli.SD.Stack.StackArray;

public class Main {

	public static void main(String[] args) throws EmptyException, FullException {
		QueueArray<Integer> queue = new QueueArray<Integer>();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(9);
		queue.enqueue(7);
		queue.enqueue(10);
		System.out.println(queue.front());
		int stop = queue.size();
		for (int i = 1; i < stop + 1; i++){
			System.out.println(i + ": " + queue.dequeue());
		}
	}

}
