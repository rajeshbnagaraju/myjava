package hacker_rank_java;

import java.util.Collection;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Queue;

/**
 * 
 * @author Rajesh Nagaraju This class is an exception that is thrown if a vertex
 *         already exists and we are still trying to add a duplicate vertex.
 */
@SuppressWarnings("serial")
class VertexExistsException extends Exception {
	VertexExistsException(String strMsg) {
		super(strMsg);
	}
}

/**
 * @author Rajesh Nagaraju The class Graph is to build the graph data structure.
 */
class Graph {
	private Map<Integer, Vertex> mapVertex = new HashMap<Integer, Vertex>();

	// private Map<Integer, List<Edge>> mapEdgeList = new HashMap<Integer,
	// List<Edge>>();
	/**
	 * Check if the vertex exists or not.
	 * 
	 * @param id
	 *            : Look up id
	 */
	boolean checkVertexExists(int id) {
		return mapVertex.get(id) != null;
	}

	/**
	 * Add the vertex or not.
	 * 
	 * @param id
	 *            : Look up id
	 */
	void addVertex(int id) throws VertexExistsException {
		Vertex ver = mapVertex.get(id);
		if (ver == null) {
			ver = new Vertex(id);
			mapVertex.put(id, ver);
		} else {
			throw new VertexExistsException("Vertex already exists");
		}
	}
	
	void resetVisitedFlags() {
		Collection<Vertex> vertexCol = mapVertex.values();
		for(Vertex vert: vertexCol){
			vert.setVisited(false);
		}
		
	}

	/**
	 * Return the map of verticies with the vertex id as the key and the vertex
	 * as its value
	 */
	public Map<Integer, Vertex> getVerticies() {
		return mapVertex;
	}

	/**
	 * Add the edge to the edge List
	 * 
	 * @param source
	 *            : Source Id
	 * @param destination
	 *            : Destination Id
	 */
	void addEdge(int source, int destination) {
		Vertex srcVertex = mapVertex.get(source);
		Vertex destVertex = mapVertex.get(destination);
		Edge edge = new Edge(srcVertex, destVertex);
		srcVertex.listEdges.add(edge);
	}

	/**
	 * Retrieve a vertex object based out of the id
	 * 
	 * @param id
	 *            : Look up id
	 */
	Vertex getVertex(int id) {
		Vertex ver = mapVertex.get(id);
		return ver;
	}

	/**
	 * Visit Edges based out of DFS @ Stack data-structure with the nodes to
	 * visit
	 */
	void visitNodesDFS(Stack<Vertex> stackNodes) {
		while (!stackNodes.isEmpty()) {
			Vertex currVertex = stackNodes.peek();
			List<Edge> edgeList = currVertex.listEdges;
			currVertex.setVisited(true);
			System.out.println("DFS Just visited:" + currVertex.id);
			for (Edge edge : edgeList) {
				Vertex destVertex = edge.destinationVertex;
				if (!destVertex.getVisited()) {
					stackNodes.add(destVertex);
					visitNodesDFS(stackNodes);
				}
			}
			System.out.println("DFS popping:" + currVertex.id);
			if (!stackNodes.isEmpty()) {
				stackNodes.pop();
			}
		}
	}

	/**
	 * Visit Edges based out of BFS @ Queue data-structure with the nodes to
	 * visit
	 */
	void visitNodesBFS(Queue<Vertex> queueNodes) {
		while (!queueNodes.isEmpty()) {
			Vertex currVertex = queueNodes.poll();
			currVertex.setVisited(true);
			List<Edge> edgeList = currVertex.listEdges;
			System.out.println("BFS Just visited:" + currVertex.id);
			for (Edge edge : edgeList) {
				Vertex destVertex = edge.destinationVertex;
				System.out.println("BFS destvertex:" +destVertex.id+"::");
				if (!destVertex.getVisited()) {
					queueNodes.add(destVertex);
				}
			}
			System.out.println("BFS popping:" + currVertex.id);
			visitNodesBFS(queueNodes);

		}
	}

	/**
	 * Depth First Search -- This uses a stack to keep track of the nodes to
	 * visit
	 */
	void depthFirstTraversal() {
		Stack<Vertex> stackNodes = new Stack<Vertex>();
		Iterator<Integer> iterVertex = mapVertex.keySet().iterator();
		if (iterVertex.hasNext()) {
			Vertex startVertex = mapVertex.get(iterVertex.next());
			stackNodes.add(startVertex);
		}
		visitNodesDFS(stackNodes);

	}

	/**
	 * Breadth First Search -- This uses a Queue to keep track of the nodes to
	 * visit
	 */
	void breadthFirstTraversal() {
		Queue<Vertex> queueNodes = new LinkedList<Vertex>();
		Iterator<Integer> iterVertex = mapVertex.keySet().iterator();
		if (iterVertex.hasNext()) {
			Vertex startVertex = mapVertex.get(iterVertex.next());
			queueNodes.add(startVertex);
		}
		visitNodesBFS(queueNodes);
	}

}

/**
 * @author Rajesh Nagaraju The class Vertex is to have information about the
 *         vertex.
 */
class Vertex {
	List<Edge> listEdges = new ArrayList<Edge>();
	int id;
	private boolean boolVisited = false;

	public void setVisited(boolean boolVisited) {
		this.boolVisited = boolVisited;
	}

	public boolean getVisited() {
		return boolVisited;
	}

	public Vertex(int id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vertex)) {
			return false;
		}
		Vertex objVer = (Vertex) obj;
		return this.id == objVer.id;
	}

	public int hashCode() {
		return this.id;
	}

	/*
	 * Print Vertex connections
	 */
	void printNode() {
		System.out.println("Vertex :" + id);
		for (Edge edge : listEdges) {
			System.out.println("    " + edge.getSource().id + " ----- "
					+ edge.getDestination().id);
		}
	}

}

/**
 * @author Rajesh Nagaraju The class Edge is to have information about the edge.
 */
class Edge {
	Vertex sourceVertex;
	Vertex destinationVertex;

	Edge(Vertex sourceVertex, Vertex destinationVertex) {
		this.destinationVertex = destinationVertex;
		this.sourceVertex = sourceVertex;
	}

	Vertex getSource() {
		return sourceVertex;
	}

	Vertex getDestination() {
		return destinationVertex;
	}

}

/**
 * @author Rajesh Nagaraju The class Even Tree is for the even tree algorithm.
 */
public class GraphsBfsDfs {
	/**
	 * 
	 * @param graph
	 * @return int : This is to return the number of edges that needs to be
	 *         removed to make an even tree
	 */
	public int getEdgeRemovals(Graph graph) {
		int iEdgeRemovals = 0;
		return iEdgeRemovals;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws VertexExistsException {
		Scanner scanner = new Scanner(System.in);
		String strLine = scanner.nextLine();
		String[] strLineToks = strLine.split(" ");
		// Get the number of edges, we are getting the edges as we will iterate
		// the edges to build the graph
		int numEdges = Integer.parseInt(strLineToks[1]);
		// --> Build the graph
		Graph graph = new Graph();

		for (int i = 0; i < numEdges; i++) {
			strLine = scanner.nextLine();
			strLineToks = strLine.split(" ");
			int source = Integer.parseInt(strLineToks[0]);
			int destination = Integer.parseInt(strLineToks[1]);
			if (!graph.checkVertexExists(source)) {
				graph.addVertex(source);
			}
			if (!graph.checkVertexExists(destination)) {
				graph.addVertex(destination);
			}
			// System.out.println("Adding edge src:"+source+"-Destination:"+destination);
			graph.addEdge(source, destination);
			// System.out.println("Added edge src and destination:"+source+"-"+destination);
		}
		// <--
		scanner.close();
		// --> Test the edges for the nodes
		Map<Integer, Vertex> mapVerticies = graph.getVerticies();
		Collection<Vertex> iterVertex = mapVerticies.values();
		for (Vertex node : iterVertex) {
			node.printNode();
		}
		// <--
		//GraphsBfsDfs evenTree = new GraphsBfsDfs();
		System.out.println("*******DFS*****");
		graph.depthFirstTraversal();
		graph.resetVisitedFlags();
		System.out.println("*******BFS*****");
		graph.breadthFirstTraversal();
		// System.out.println(evenTree.getEdgeRemovals(graph));
	}
}