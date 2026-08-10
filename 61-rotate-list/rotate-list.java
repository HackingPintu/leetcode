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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0) return head;
        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next; 
        }
        temp.next=head;
        int rotate=k%len;
        if(rotate==0) {
            temp.next=null;
            return head;
        }
        rotate=len-rotate;
        int i=1;
        temp=head;
        while(i!=rotate){
            i++;
            temp=temp.next;
        }

        ListNode newHead=temp.next;

        temp.next=null;

        return newHead;    
        

    }
}