package hacker_rank_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author rajeshnagaraju
 * An vertex with the start can have
 * only 1 edge, hence we dont need a list for edges
 */
class ConnectionVertex {
	
	private int id;
	private SnakeAndLadderConnection connectedEdge = null;
	public ConnectionVertex(int id,SnakeAndLadderConnection connectedEdge) {
		this.id = id;
		this.connectedEdge = connectedEdge;
	}
}

class SnakeAndLadderConnection {
	private int sourceId;
	private int destId;
	public SnakeAndLadderConnection(int sourceId, int destId) {
		this.sourceId=sourceId;
		this.destId=destId;
	}
}

class BoardAsGraph {
	private Map<Integer,ConnectionVertex> connections = new HashMap<Integer,ConnectionVertex>();
	
	public void clear() {
		connections.clear();
	}
	public void addConnection(int id,ConnectionVertex node) {
		connections.put(Integer.valueOf(id), node);
	}

}

class DijkestraAlgo {
	// setting it to 101 as the index 0 is ignored
	int[] iBoard = null;
    
	public void printBoard() {
		// int iRow = 0;
		for (int iColumn = 1; iColumn < 101; iColumn++) {
			System.out.print(iBoard[iColumn] + "            ");
		}

	}

	public void initialize() {
		int rowIndex = 1;
		iBoard = new int[101];
		for (int colIndex = 1; colIndex < 101; colIndex++) {
			if (colIndex == rowIndex) {
				iBoard[colIndex] = 0;
			} else {
				iBoard[colIndex] = (colIndex / 6) + 1;
			}
		}

	}
}

public class SnakeAndLadders {
	public static void main(String[] args) {
		
		BoardAsGraph board = new BoardAsGraph();
		Scanner scanner = new Scanner(System.in);
		int iTestCases = Integer.parseInt(scanner.nextLine());
		DijkestraAlgo dAlgo = new DijkestraAlgo();
		for (int iTC = 0; iTC < iTestCases; iTC++) {
			dAlgo.initialize();
			int iSnakesLadders = Integer.parseInt(scanner.nextLine());
			for (int iEdgeIndex = 0; iEdgeIndex < iSnakesLadders; iEdgeIndex++) {
				String[] connections = scanner.nextLine().split(" ");
				int iStart = Integer.parseInt(connections[0]);
				int iEnd = Integer.parseInt(connections[1]);
				//board.iBoard[iStart][iEnd] = 1;
				SnakeAndLadderConnection conn = new SnakeAndLadderConnection(iStart,iEnd);
				ConnectionVertex node = new ConnectionVertex(iStart,conn);
				board.addConnection(iStart, node);
			}
		}
		System.out.println("******initial distance:" + dAlgo.iBoard[100]);
		dAlgo.printBoard();
		scanner.close();
	}

}
