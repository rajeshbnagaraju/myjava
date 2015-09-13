package hacker_rank_java;

class BinarySearchTreeNode {
	BinarySearchTreeNode leftNode = null;
	long iValue;

	public BinarySearchTreeNode(long iValue) {
		this.iValue = iValue;
	}

	public BinarySearchTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinarySearchTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	BinarySearchTreeNode rightNode = null;

	public BinarySearchTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinarySearchTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	BinarySearchTreeNode parentNode = null;

	public BinarySearchTreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(BinarySearchTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	public long getiValue() {
		return iValue;
	}

}

public class BinarySearchTree {
	// int iRootNodeValue;
	BinarySearchTreeNode rootNode;
	boolean leftNode = false;

	void addNode(long iValue) {
		if (rootNode == null) {
			rootNode = new BinarySearchTreeNode(iValue);
			return;
		}
		if (rootNode.iValue == iValue) {
			return;
		}
		BinarySearchTreeNode parentNode = rootNode;
		BinarySearchTreeNode node;
		if (iValue > rootNode.iValue) {
			node = rootNode.rightNode;
		} else {
			leftNode = true;
			node = rootNode.leftNode;
		}
		while (node != null) {
			if (node.iValue == iValue) {
				return;
			}
			parentNode = node;
			if (iValue > node.iValue) {
				node = node.rightNode;
				leftNode = false;
			} else {
				leftNode = true;
				node = node.leftNode;
			}
		}
		node = new BinarySearchTreeNode(iValue);
		node.parentNode = parentNode;
		if (leftNode) {
			parentNode.leftNode = node;
			//leftNode=false;
		} else {
			parentNode.rightNode = node;
		}
	}
	
	
	
	boolean searchTree(long iValue) {
		
		if(iValue==rootNode.iValue){
			return true;
		}
		BinarySearchTreeNode node = rootNode.iValue>iValue?rootNode.leftNode:rootNode.rightNode;
		while (node!=null) {
			if(iValue==node.iValue){
				return true;
			}
			node = node.iValue>iValue?node.leftNode:node.rightNode;
		}
		return false;
	}

	void printTree(BinarySearchTreeNode node, boolean isRootNode) {
		if (isRootNode) {
			node = rootNode;
			System.out.println("       " + node.iValue + "          ");
		}
		BinarySearchTreeNode leftNode = node.leftNode;
		BinarySearchTreeNode rightNode = node.rightNode;
		if (leftNode != null || rightNode != null) {
			String leftNodeValue = leftNode == null ? "XXX" : leftNode.iValue + "";
			String rightNodeValue = rightNode == null ? "XXX" : rightNode.iValue + "";
			System.out.println(leftNodeValue
					+ "                                    " + rightNodeValue);
			if (leftNode != null) {
				printTree(leftNode, false);
			}
			if (rightNode != null) {
				printTree(rightNode, false);
			}
		}
	}
}
