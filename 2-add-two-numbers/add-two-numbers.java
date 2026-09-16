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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while (temp1 != null && temp2 != null){
            int val = carry + temp1.val + temp2.val;
            if (val > 9) {
                carry = 1;
                val -= 10;
            }else {
                carry = 0;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null && temp2 == null){
            int val = temp1.val + carry;
            if (val > 9){
                carry = 1;
                val -= 10;
            }else{
                carry = 0;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
            temp1 = temp1.next;

        }
        while (temp2 != null && temp1 == null){
            int val = temp2.val + carry;
            if (val > 9){
                carry = 1;
                val -= 10;
            }else{
                carry = 0;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
            temp2 = temp2.next;

        }

        if (carry == 1) temp.next = new ListNode(1);

        return dummy.next;
    }
}