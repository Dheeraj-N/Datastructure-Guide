package Stack;

import java.util.Arrays;

public class Stack {

	 private int[] arr = new int[5];
	 private int count = 0;
	 
	 public void push(int data) {
		 if(count == arr.length)
			 throw new StackOverflowError();
		 
		 arr[count] = data;
		 count++;
	 }
	 
	 public void pop() {
		 if(count == 0)
			 throw new IllegalStateException();
		 
		 arr[--count] = 0;
	 }
	 
	 public int peek() {
		 if(count == 0)
			 throw new IllegalStateException();
		 
		 return arr[count-1];
	 }
	 
	 public boolean isEmpty() {
		 return count == 0;
	 }
	 
	 public String toString() {
		 int[] result = Arrays.copyOfRange(arr, 0, count);
		 return Arrays.toString(result);
	 }
}
