package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
	
    private class Node{    	
    	 int value;
    	 Node next;
    	
    	public Node(int value) {
    		this.value = value;
    	}
    }
    
    private Node first;
    private Node last;
    private int size;
    
    
    private boolean isEmpty() {
    	return first == null; 
    }
    
    public void append(int data) {
    	Node newNode = new Node(data);
    	
    	if(first == null) {
    		first = newNode;
    		last = newNode;
    	}
    	else {
    		last.next = newNode;
    		last = newNode;
    	}
    	size++;
    }
    
    public void addFirst(int data) {
    	Node newNode = new Node(data);
    	
    	if(isEmpty()) {
    		first = newNode;
    		last = newNode;
    	}
    	else {
    		newNode.next = first;
    		first = newNode;
    	}
    	size++;
    }
    
    public void display() {
    	Node current = first;    	
    	while(current != null) {
    		System.out.print(current.value+" ");
    		current = current.next;
    	}
    	System.out.println();
    }
    
    public int indexOf(int data) {
    	int index = 0;
    	Node current = first;
    	while(current != null) {
    		if(current.value == data)
    			return index;
    		index++;
    		current = current.next;
    	}
    	return -1;
    }
    
    public boolean contains(int data) {
    	return indexOf(data) != -1;
    }
    
    public void deleteFirst() {
    	if(isEmpty()) {
    		throw new NoSuchElementException() ;
    	}
    	
    	if(first == last)
    		first = last = null;
    	
    	Node current = first.next;
    	first.next = null;
    	first = current;
    	size--;
    }
    
    
    public void deleteLast() {
    	
    	if(isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	
    	if(first == last)
    		first = last = null;
    	
    	Node current = first;
    	while(current.next != last) {
    		current = current.next;
    	}
    	last = current;
    	last.next = null;
    	size--;
    }
    
    public int size() {
    	return size;
    }
    
    public void reverse() {
    	if(isEmpty()) {
    	    return;
    	}
    	
    	if(first == last) {
    		return ;
    	}
    	
    	Node current = first;
    	Node prev = null,temp = null;
    	while(current != null) {
    		temp = prev;
    		prev = current;
    		current = current.next;
    		prev.next = temp;
    	}
    	last = first;
    	first = prev;
    	
    }
    
    public int getKthNodeFromEnd(int n) {
    	if(isEmpty())
    		throw new IllegalStateException();
    	Node temp1 = first;
    	Node temp2 = first;
    	while(n-1>0) {
    		temp1 = temp1.next;
    		if(temp1 == null) {
    			throw new IllegalArgumentException();
    		}
    		n--;
    	}
    	while(temp1 != last) {
    		temp1 = temp1.next;
    		temp2 = temp2.next;
    	}
    	return temp2.value;
    }
    
}
