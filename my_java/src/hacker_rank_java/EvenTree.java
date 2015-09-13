package hacker_rank_java;

import java.util.HashSet;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Debug {
	static boolean boolDebug = true;

	static void debug(String strMsg) {
		if (boolDebug) {
			System.out.println(strMsg);
		}
	}
}

/**
 * 
 * @author Rajesh Nagaraju This class is an exception that is thrown if a vertex
 *         already exists and we are still trying to add a duplicate vertex.
 * 
 */
@SuppressWarnings("serial")
class EvenTreeVertexExistsException extends Exception {
	EvenTreeVertexExistsException(String strMsg) {
		super(strMsg);
	}
}

/**
 * @author Rajesh Nagaraju The class Graph is to build the graph data structure.
 */
class EvenTreeGraph {
	private Map<Integer, EvenTreeVertex> mapVertex = new HashMap<Integer, EvenTreeVertex>();

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
	void addVertex(int id) throws EvenTreeVertexExistsException {
		EvenTreeVertex ver = mapVertex.get(id);
		if (ver == null) {
			ver = new EvenTreeVertex(id);
			mapVertex.put(id, ver);
		} else {
			throw new EvenTreeVertexExistsException("Vertex already exists");
		}
	}

	/**
	 * Return the map of verticies with the vertex id as the key and the vertex
	 * as its value
	 */
	public Map<Integer, EvenTreeVertex> getVerticies() {
		return mapVertex;
	}

	/**
	 * Add the edge to the edge List
	 * 
	 * @param parent
	 *            : Source Id
	 * @param child
	 *            : Destination Id
	 */
	void addEdge(int parent, int child) {
		EvenTreeVertex parentVertex = mapVertex.get(parent);
		EvenTreeVertex childVertex = mapVertex.get(child);
		parentVertex.addEdgeNode(childVertex);
		parentVertex.addChildNode(childVertex);
		childVertex.addEdgeNode(parentVertex);
		childVertex.setParent(parentVertex);
	}

	/**
	 * Retrieve a vertex object based out of the id
	 * 
	 * @param id
	 *            : Look up id
	 */
	EvenTreeVertex getVertex(int id) {
		EvenTreeVertex ver = mapVertex.get(id);
		return ver;
	}

	private int getChildren(EvenTreeVertex node) {
		int iChildren = node.getNumChildren();
		Set<EvenTreeVertex> childNodeSet = node.getChildrenNodeSet();
		for (EvenTreeVertex childNode : childNodeSet) {
			iChildren += getChildren(childNode);
		}
		return iChildren;
	}

	int getEvenTreeCalculation() {
		Iterator<Integer> keySetIter = mapVertex.keySet().iterator();
		EvenTreeVertex rootNode = null;
		while (keySetIter.hasNext()) {
			EvenTreeVertex currNode = mapVertex.get(keySetIter.next());
			if (currNode.getParent() == null) {
				rootNode = currNode;
				break;
			}
		}
		//Debug.debug("rootNode:"+rootNode.id);
		return getEdgeRemovals(rootNode);
	}

	/**
	 * 
	 */
	int getEdgeRemovals(EvenTreeVertex node) {
		//Debug.debug("getEdgeRemovals:"+node.id);
		int iEdgeRemovals = 0;
		int iChildren = 0;
		Set<EvenTreeVertex> childNodeSet = node.getChildrenNodeSet();
		for (EvenTreeVertex childNode : childNodeSet) {
		    iChildren = getChildren(childNode)+1; // needed to include the parent
			if (iChildren % 2 == 0 && iChildren != 0) {
				//Debug.debug("***removal node id:"+node.id);
				iEdgeRemovals = iEdgeRemovals + 1;
			}
			iEdgeRemovals += getEdgeRemovals(childNode);
		}
		return iEdgeRemovals;

	}

}

/**
 * @author Rajesh Nagaraju The class EvenTreeVertex is to have information about
 *         the vertex.
 */
class EvenTreeVertex {
	int id;
	private Set<EvenTreeVertex> edgeNodesSet = new HashSet<EvenTreeVertex>();
	private boolean boolVisited = false;
	private Set<EvenTreeVertex> childrenNodeSet = new HashSet<EvenTreeVertex>();

	public Set<EvenTreeVertex> getChildrenNodeSet() {
		return childrenNodeSet;
	}

	private EvenTreeVertex parent = null;

	public int getNumChildren() {
		return childrenNodeSet.size();
	}

	public EvenTreeVertex getParent() {
		return parent;
	}

	public void setParent(EvenTreeVertex parent) {
		this.parent = parent;
	}

	public void addEdgeNode(EvenTreeVertex vertex) {
		edgeNodesSet.add(vertex);
	}

	public void addChildNode(EvenTreeVertex vertex) {
		childrenNodeSet.add(vertex);
	}

	/*
	 * public void removeEdgeNode(EvenTreeVertex vertex) {
	 * childrenNodeSet.remove(vertex); }
	 */

	public Set<EvenTreeVertex> getEdgeNodes() {
		return edgeNodesSet;
	}

	public EvenTreeVertex(int id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EvenTreeVertex)) {
			return false;
		}
		EvenTreeVertex objVer = (EvenTreeVertex) obj;
		return this.id == objVer.id;
	}

	public int hashCode() {
		return this.id;
	}

	/**
	 * Print EvenTreeVertex connections
	 */
	void printNode() {
		for (EvenTreeVertex connectedEdge : edgeNodesSet) {
			Debug.debug("    " + id + " ----- " + connectedEdge.id);
		}
	}

	public boolean isBoolVisited() {
		return boolVisited;
	}

	public void setBoolVisited(boolean boolVisited) {
		this.boolVisited = boolVisited;
	}

}

/**
 * @author Rajesh Nagaraju The class Edge is to have information about the edge.
 */
class EvenTreeEdge {
	EvenTreeVertex sourceVertex;
	EvenTreeVertex destinationVertex;
	boolean deleted = false;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	EvenTreeEdge(EvenTreeVertex sourceVertex, EvenTreeVertex destinationVertex) {
		this.destinationVertex = destinationVertex;
		this.sourceVertex = sourceVertex;
	}

	EvenTreeVertex getSource() {
		return sourceVertex;
	}

	EvenTreeVertex getDestination() {
		return destinationVertex;
	}

}

/**
 * @author Rajesh Nagaraju The class Even Tree is for the even tree algorithm.
 */
public class EvenTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws EvenTreeVertexExistsException {
		//Debug.boolDebug = false;
		Scanner scanner = new Scanner(System.in);
		String strLine = scanner.nextLine();
		String[] strLineToks = strLine.split(" ");
		// Get the number of edges, we are getting the edges as we will iterate
		// the edges to build the graph
		int numEdges = Integer.parseInt(strLineToks[1]);
		// EvenTreeVertex parent = null;
		// --> Build the graph
		EvenTreeGraph graph = new EvenTreeGraph();
		for (int i = 0; i < numEdges; i++) {
			strLine = scanner.nextLine();
			strLineToks = strLine.split(" ");
			int source = Integer.parseInt(strLineToks[0]);
			int destination = Integer.parseInt(strLineToks[1]);
			int parent = source;
			int child = destination;
			if (!graph.checkVertexExists(source)) {
				graph.addVertex(source);
				// if source does not exist then swap the parent and child
				child = source;
				parent = destination;
			}
			if (!graph.checkVertexExists(destination)) {
				graph.addVertex(destination);

			}
			graph.addEdge(parent, child);
		}
		// <--
		scanner.close();

		//EvenTree evenTree = new EvenTree();
		int iEdgeRemovals = graph.getEvenTreeCalculation();
		if(iEdgeRemovals==0) {
			iEdgeRemovals = -1;
		}
		System.out.println(iEdgeRemovals);
		// -->Test the edges for the nodes
		/*
		 * boolean origDebug = Debug.boolDebug; Debug.boolDebug=true;
		 * Map<Integer, EvenTreeVertex> mapVerticies = graph.getVerticies();
		 * Collection<EvenTreeVertex> iterVertex = mapVerticies.values(); for
		 * (EvenTreeVertex node : iterVertex) { node.printNode(); }
		 * Debug.boolDebug=origDebug;
		 */
		// <--

	}
}