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


        
        ListNode result = new ListNode(-1);
        ListNode itr = result;
        
        for(int i = 0;i<lists.length;i++)
        {
            if(lists[i] != null)
            pq.offer(lists[i]);
        }

        while(!pq.isEmpty())
        {
            ListNode temp = pq.remove();
            if(temp.next != null)
                pq.offer(temp.next);
            temp.next = null;
            itr.next = temp;
            itr = itr.next;
            
        }

        return result.next;
          
        
    }
}