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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode list : lists){
            if(list != null) queue.add(list);
        }

        ListNode dummy = new ListNode(-1), temp = dummy;

        while(!queue.isEmpty()){
            ListNode smallestNode = queue.poll();
            temp.next = smallestNode;
            temp = temp.next;

            if(smallestNode.next != null){
                queue.add(smallestNode.next);
            }
        }

        return dummy.next;

        
    }
}