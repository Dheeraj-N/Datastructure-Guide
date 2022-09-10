package Heap;

public class MaxHeap {
	public static void heapify(int[] array) {
		for(int i=array.length/2 -1;i>=0;i--) {
			heapify(array, i);
		}
	}
	
	private static void heapify(int[] array, int index) {
		int largerIndex = index;
		
		int leftChild = index * 2 + 1;
		if(leftChild < array.length && array[leftChild] > array[largerIndex]) {
			largerIndex = leftChild;
		}
		
		int rightChild = index * 2 + 2;
		if(rightChild < array.length && array[rightChild] > array[largerIndex]) {
			largerIndex = rightChild;
		}
		
		if(index == largerIndex)
			return;
		
		swap(array, index, largerIndex);
		heapify(array,largerIndex);
	}
	
	private static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public static int getKthMaxValue(int[] array, int k) {
		if(k < 1 || k > array.length)
			throw new IllegalStateException();
		
		Heap h = new Heap();
		for(int i:array)
			h.insert(i);
		
		for(int i = 1;i<k;i++) {
			h.remove();
		}
		return h.maxValue();
	}
}
