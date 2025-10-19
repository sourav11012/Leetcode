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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);

        for(int i = 0;i<lists.length; i++)
        {
            ListNode head = lists[i];
            while(head != null)
            {   
                
                pq.offer(head);
                head = head.next;
               
            }
        }
        ListNode newhead = new ListNode(-1);
        ListNode itr = newhead;
        while(!pq.isEmpty())
        {
            ListNode temp = pq.remove();
            temp.next = null;
            itr.next = temp;
            itr = itr.next;

        }
        return newhead.next;
    }
}