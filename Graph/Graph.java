package Graph;

import java.util.*;

public class Graph {
	
	private class Node{
		String label;
		
		public Node(String label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
		
		
	}
	
	private Map<String, Node> entries = new HashMap<>();
	private Map<Node, List<Node>> adjacencyList = new HashMap<>();
	
	public void addNode(String label) {
	
		Node newNode = new Node(label);
		entries.putIfAbsent(label, newNode);
		adjacencyList.putIfAbsent(newNode, new ArrayList<>());
	}
	
	public void addEdge(String from , String to) {
		Node fromNode = entries.get(from);
		if(fromNode == null)
			throw new IllegalStateException();
		
		Node toNode = entries.get(to);
		if(toNode == null)
			throw new IllegalStateException();
		
		adjacencyList.get(fromNode).add(toNode);
	}
	
	public void print() {
		for(Node source : adjacencyList.keySet()) {
			List<Node> target = adjacencyList.get(source);
			if(!target.isEmpty()) {
				System.out.println(source+" is connected to "+target);
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void removeNode(String label) {
		Node node = entries.get(label);
		if(node == null)
			return;
		
		for(Node n : adjacencyList.keySet()) {
			adjacencyList.get(n).remove(node);
		}
		
		adjacencyList.remove(node);
		entries.remove(node);
	}
	
	public void removeEdge(String from, String to) {
		Node fromNode = entries.get(from);
		Node toNode = entries.get(to);
		
		if(fromNode == null || toNode == null)
			return;
		
		adjacencyList.get(fromNode).remove(toNode);
	}
	
	
	public void traversalDepthFirst(String root) {
		Node node = entries.get(root);
		if(node == null)
			return;
		traversalDepthFirst(node,new HashSet<>());
	}
	
	private void traversalDepthFirst(Node root, Set<Node> visited) {
		System.out.println(root);
		visited.add(root);
		
		for(Node node : adjacencyList.get(root)) {
			if(!visited.contains(node)) {
				traversalDepthFirst(node,visited);
			}
		}
	}
	
	public void traversalDepthFirstItr(String root) {
		Node node = entries.get(root);
		if(node == null)
			return;
		
		Set<Node> visited = new HashSet<>();
		Stack<Node> stk = new Stack<>();
		stk.push(node);
		
		while(!stk.isEmpty()) {
			Node current = stk.pop();
			
			if(!visited.contains(current))
			System.out.println(current);
			visited.add(current);
			
			for(Node neighbour : adjacencyList.get(current)) {
				if(!visited.contains(neighbour)) {
				   stk.push(neighbour);	
				}
			}
		}
	}
	
	public void traversalBreadthFirst(String root) {
		Node node = entries.get(root);
		if(node == null)
			return;
		
		Set<Node> visited = new HashSet<>();
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		
		while(!q.isEmpty()) {
			Node current = q.remove();
			
			if(visited.contains(current))
				continue;
				
			System.out.println(current);
			visited.add(current);
			
			for(Node neighbour: adjacencyList.get(current)) {
				if(!visited.contains(neighbour)) {
					q.add(neighbour);
				}
			}
			
		}		
	}
	
	
	public List<String> topologicalSort(){
		
		Set<Node> visited = new HashSet<>();
		Stack<Node> stk = new Stack<>();
		for(Node node : entries.values())
			topologicalSort(node, visited, stk);
		
		List<String> sorted =  new ArrayList<>();
		while(!stk.empty()) {
			sorted.add(stk.pop().label);
		}
		
		return sorted;
	}
	
	private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stk) {
		
		if(visited.contains(node))
			return;
		
		visited.add(node);
		
		for(Node neighbour : adjacencyList.get(node)) {
			if(!visited.contains(neighbour))
				topologicalSort(neighbour, visited, stk);
		}
		
		stk.push(node);		
	}
	
	public boolean hasCycle() {
		Set<Node> all = new HashSet<>();
		all.addAll(entries.values());
		
		Set<Node> visiting = new HashSet<>();
		Set<Node> visited = new HashSet<>();
		
		while(!all.isEmpty()) {
			Node current = all.iterator().next();
			
			if(hasCycle(current, all, visiting, visited))
				return true;
		}
		return false;
	} 
	
	private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
		all.remove(node);
		visiting.add(node);
		
		for(Node neighbour : adjacencyList.get(node)) {
			if(visited.contains(neighbour))
				continue;
			
			if(visiting.contains(neighbour))
				return true;
			
			if(hasCycle(neighbour, all, visiting, visited))
				return true;
		}
		
		visiting.remove(node);
		visited.add(node);
		
		return false;
	}
	
	

}
