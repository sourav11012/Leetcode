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
        while(true){
            for(int i = 0;i<lists.length; i++)
            {
                if(lists[i] != null)
                {
                ListNode head = lists[i];
                pq.offer(head);
                lists[i] = lists[i].next;
                }
                
            }
            if(pq.isEmpty()) break;
            ListNode temp = pq.remove();
            temp.next = null;
            itr.next = temp;
            itr = itr.next;
            
        
        }

        return result.next;
          
        
    }
}