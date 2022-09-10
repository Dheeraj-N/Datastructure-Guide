package Graph;

import java.util.*;

public class WeightedGraph {

	private class Node{
		private String label;
		private List<Edge> edges = new ArrayList<>();
		public Node(String label){
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
		
		public void addEgde(Node toNode, int weight) {
			edges.add(new Edge(this,toNode,weight));
		}
		
		public List<Edge> getEdges(){
			return edges;
		}
		
	}
	
	private class Edge{
		Node fromNode;
		Node toNode;
		int weight;
		
		public Edge(Node fromNode, Node toNode, int weight) {
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return fromNode+"->"+toNode;
		}
		
		
	}
	
	private Map<String, Node> entries = new HashMap<>(); 
	//private Map<Node, List<Edge>> adjacencyList = new HashMap<>();
	
	public void addNode(String label) {
		//Node newNode = new Node(label);
		entries.putIfAbsent(label, new Node(label));
		//adjacencyList.putIfAbsent(newNode, new ArrayList<>());
	}
	
	public void addEdge(String from, String to, int weight) {
		Node fromNode = entries.get(from);
		if(fromNode == null)
			throw new IllegalStateException();
		
		Node toNode = entries.get(to);
		if(toNode == null)
			throw new IllegalStateException();
		
		fromNode.addEgde(toNode, weight);
		toNode.addEgde(fromNode, weight);
		//adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
		//adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
	}
	
	public void print() {
		for(Node node : entries.values()) {
			List<Edge> edges = node.getEdges();
			if(!edges.isEmpty()) {
				System.out.println(node+" is connected to "+edges);
			}
		}
	}
	
	
	public boolean hasCycle() {
		
		Set<Node> visited = new HashSet<>();
		
 		for(Node node:entries.values()) {
		    if(!visited.contains(node) && hasCycle(node, null, visited))
		    		return true;
		    }		    	
	 return false;
	}
	
	private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
		
		visited.add(node);
		
		for( Edge edge : node.getEdges()) {
			
			Node current = edge.toNode;
			if(current == parent)
				continue;
			
			if(visited.contains(current) || hasCycle(current, node, visited))
				return true;
			
		}
		
		return false;
	}
} 
