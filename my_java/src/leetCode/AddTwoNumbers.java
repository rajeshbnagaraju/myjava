package leetCode;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode outNextNode = null;
		if (l1.next != null || l2.next != null) {
			outNextNode = addTwoNumbers(l1.next == null ? l1 : l1.next,
					l2.next == null ? l2 : l2.next);
		}
		int iVal = (outNextNode == null ? 0 : outNextNode.val) + l1.val
				+ l2.val;
		outNextNode = new ListNode(iVal / 10);
		outNextNode.next = new ListNode(iVal % 10);
		return outNextNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
