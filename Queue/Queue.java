package Queue;

import java.util.*;

public class Queue {

	private int[] arr = new int[5];
	private int rear = 0;
	private int front = 0;
	private int count = 0;
	
	public void enqueue(int data) {
		if(isFull())
			throw new IllegalStateException();
		
		arr[rear] = data;
		rear = (rear+1) % arr.length;
		count++;
	}
	
	public void dequeue() {
		if(isEmpty())
			throw new IllegalStateException();
		arr[front] = 0;
		front = (front+1) % arr.length;
		count--;
 	}
	
	public int peek() {
		return arr[front];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == arr.length;
	}
	
	public String toString() {
		return Arrays.toString(arr);
	}
	
	
	
}
