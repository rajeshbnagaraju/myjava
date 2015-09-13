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
		if (l1 == null) {
			return l2.next;
		}
		if (l2 == null) {
			return l1.next;
		}
		ListNode outNextNode = null;
		if (l1.next != null || l2.next != null) {
			outNextNode = addTwoNumbers(l1, l2);
		}
		int iVal = (outNextNode == null ? 0 : outNextNode.val) + l1.val
				+ l2.val;
		ListNode currNode = new ListNode(iVal % 10);
		int iQuotient = iVal / 10;
		if (iQuotient != 0) {
			outNextNode = new ListNode(iQuotient);
		}
		currNode.next = outNextNode;
		return currNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
