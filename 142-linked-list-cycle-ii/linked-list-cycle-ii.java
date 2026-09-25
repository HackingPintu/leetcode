/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Hashing
        // Set<ListNode> set= new HashSet<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     if(set.contains(temp)) return temp;
        //     set.add(temp);
        //     temp=temp.next;
        // }

        // return null;
        if(head==null || head.next==null) return null;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }

        if(slow!=fast) return null;

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }
}