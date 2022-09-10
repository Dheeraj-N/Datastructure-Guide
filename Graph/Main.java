package Graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*  Directed Graph
		Graph g = new Graph();
		g.addNode("John");
		g.addNode("Mary");
		g.addNode("Bob");
		g.addNode("Alice");
		g.addEdge("John", "Mary");
		//g.addEdge("Bob", "John");
		g.addEdge("John", "Alice");
		g.addEdge("Mary", "Alice");
		g.addEdge("Mary", "Bob");
		g.addEdge("Alice", "Bob");
		//g.removeEdge("Mary","Bob");
		//g.removeNode("Mary");
		g.traversalDepthFirstItr("John");
		g.traversalBreadthFirst("John");
		List <String> ts = g.topologicalSort();
		System.out.println(ts);
		System.out.println(g.hasCycle());
	*/
		
		WeightedGraph graph = new WeightedGraph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addEdge("A", "B", 3);
		//graph.addEdge("A", "C", 6);
		graph.addEdge("C", "D", 5);
		graph.addEdge("B", "C", 5);
		graph.addEdge("A", "D", 1);
		graph.print();
		System.out.println(graph.hasCycle());
	}

}
