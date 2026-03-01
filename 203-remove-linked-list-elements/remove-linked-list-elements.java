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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases (like removing the head itself)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use two pointers: prev (tracks the node before current) and curr (the node being checked)
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev forward only if we don't delete curr
                prev = curr;
            }
            // Move curr forward
            curr = curr.next;
        }
        
        // Return the new head (dummy.next handles cases where head was removed)
        return dummy.next;
    }
}