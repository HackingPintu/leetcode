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
    public ListNode reverseList(ListNode head) {
        // if (head == null || head.next == null) return head;
        // ListNode temp = head;
        // ListNode prev = null;
        // while (temp != null){
        //     ListNode nextNode = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = nextNode; 

        // }

        // return prev;
        return recursion(head);
    }

    public ListNode recursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = recursion(head.next);

        head.next.next = head;

        head.next = null;

        return newHead;
        
    }

   
}