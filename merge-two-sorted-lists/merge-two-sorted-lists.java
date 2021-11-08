/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// maintain an unchanging reference to node ahead of the return node.
		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// At least one of l1 and l2 can still have nodes at this point, so connect
		// the non-null list to the end of the merged list.
		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}
	
	
	
	  public static void main(String[] args) {
//		    int[] arr1 = new int[] {1, 3, 5, 6};
//		    int[] arr2 = new int[] {2, 4, 6, 20, 34};
		    	    
		    ListNode l1_a = new ListNode(1);
		    ListNode l1_b = new ListNode(3);
		    ListNode l1_c = new ListNode(5);
		    ListNode l1_d = new ListNode(6);
		    
		    l1_a.next = l1_b;
		    l1_b.next = l1_c;
		    l1_c.next = l1_d;
		    
		    
		    ListNode l2_a = new ListNode(2);
		    ListNode l2_b = new ListNode(4);
		    ListNode l2_c = new ListNode(6);
		    ListNode l2_d = new ListNode(20);
		    ListNode l2_e = new ListNode(34);
		    
		    l2_a.next = l2_b;
		    l2_b.next = l2_c;
		    l2_c.next = l2_d;
		    l2_d.next = l2_e;
		    
		    ListNode mergeList = mergeTwoLists(l1_a, l2_a);
		    System.out.println("mergeList " + mergeList);
		    
     }
}