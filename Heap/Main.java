package Heap;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap heap = new Heap();
		/*heap.insert(10);
		heap.insert(7);
		heap.insert(15);
		heap.insert(8);
		heap.insert(3);
		heap.insert(21);
		heap.remove();
		System.out.println("Done..");
		*/
		// Implementing Heap Sort
		
		int[] array = {4,2,5,7,8,9,3,6};
		//int[] array = {5,4,1,2,8};
		/*for(int i:array)
			heap.insert(i);
		for(int i=array.length-1;i>=0;i--)
			array[i] = heap.remove();		
		System.out.println(Arrays.toString(array));
		*/
		MaxHeap.heapify(array);
		System.out.println(Arrays.toString(array));
		
		int result = MaxHeap.getKthMaxValue(array,8);
		System.out.println(result);
	}

}
