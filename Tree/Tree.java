package Tree;
import java.util.*;
public class Tree {
	
	private class Node{
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node="+ value;
		}
	}
	
	private Node root;
	
	public void insert(int value) {
		
		Node newNode = new Node(value);
		
		if(root == null) {
			root = newNode;
			return ;
		}
		
		Node current = root;
		while(true) {
			if(value < current.value) {
				if(current.leftChild == null) {
					current.leftChild = newNode;
					break;
				}
				current = current.leftChild;
			}
			else {
				if(current.rightChild == null) {
					current.rightChild = newNode;
					break;
				}
				current = current.rightChild;
			}
		}
    }
	
	public boolean find(int value) {
		Node current = root;
		
		while(current != null) {
			if(value < current.value) {
				current = current.leftChild;
			}
			else if(value > current.value){
				current = current.rightChild;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(Node current) {
		if(current == null)
			return ;
		
		inOrderTraversal(current.leftChild);
		System.out.print(current.value+" ");
		inOrderTraversal(current.rightChild);
		
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	private void preOrderTraversal(Node current) {
		if(current == null)
			return ;
		
		System.out.print(current.value+" ");
		preOrderTraversal(current.leftChild);
		preOrderTraversal(current.rightChild);
		
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(root);
		System.out.println();
	}
	
	private void postOrderTraversal(Node current) {
		if(current == null)
			return ;
		
		postOrderTraversal(current.leftChild);
		postOrderTraversal(current.rightChild);
		System.out.print(current.value+" ");
	}
	
	
	
	public void levelOrderTraversal() {
		if(root == null)
			return ;
		
		Queue<Node> q = new LinkedList<>();
		Node current;
		q.add(root);
		
		while(!q.isEmpty()) {			
			current = q.poll();			
			if(current != null) {
				q.add(current.leftChild);
				q.add(current.rightChild);
				System.out.print(current.value+" ");
			}
		}
		System.out.println();
		
		
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node root) {
		if(root.leftChild == null && root.rightChild == null)
			return 0;
		
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}
	
	public int min() {
		return min(root);
	}
	
	private int min(Node root) {
		if(root.leftChild == null && root.rightChild == null)
			return root.value;
		
		int left = min(root.leftChild);
		int right = min(root.rightChild);
		
		return Math.min(Math.min(left, right), root.value);
	}
	
	
	public boolean equals(Tree other) {
		if(other == null)
			return false;
		return equals(root,other.root);
	}
	private boolean equals(Node root,Node other) {
		if(root == null && other == null)
			return true;
		
		if(root != null && other!= null) {
			return root.value == other.value 
					&& equals(root.leftChild , other.leftChild)
					&& equals(root.rightChild , other.rightChild);
		}
		return false;
	}
	
	public void swap() {
		Node temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}
	
	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBinarySearchTree(Node root,int min,int max) {
		if(root == null)
			return true;
		
		if(root.value > max || root.value < min)
			return false;
		
		return isBinarySearchTree(root.leftChild , min , root.value - 1) && isBinarySearchTree(root.rightChild , root.value+1 , max);
	}
	
	public void printNodesAtDistance(int distance) {
		printNodesAtDistance(root, distance);
	}
	
	private void printNodesAtDistance(Node root, int distance) {
		if(root == null)
			return;
		
		if(distance == 0) {
			System.out.println(root.value);
			return;
		}
		
		printNodesAtDistance(root.leftChild,distance-1);
		printNodesAtDistance(root.rightChild,distance-1);
			
	}
	
	
	
	

}
