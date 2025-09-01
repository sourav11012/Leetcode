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
    public ListNode sortList(ListNode head) {
    
        PriorityQueue<ListNode> pq = new PriorityQueue<>(( a, b) -> Integer.compare(a.val,b.val));
        ListNode itr = head;

        while(itr!= null)
        {
            pq.add(itr);
            itr = itr.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = temp;
        } curr.next = null;

        return dummy.next;
    }
}