// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
    
//     public ListNode reverse(ListNode head, int k)
//     {
//         ListNode itr = head;

//         int count = 1;
//         while(count < k && itr != null)
//         {
//             itr = itr.next;
//             count++;
//         }
//         // ListNode end  =itr;
       
//         ListNode prevNode = null;
//         if(count == k && itr != null) {
//             prevNode = reverse(itr.next,k );
//         }else{
//             return head;
//         }
       

//         itr = head;
//         count = 0;
//         while(count <= k)
//         {
//             ListNode temp = itr.next;
//             itr.next = prevNode;
//             prevNode = itr;
//             itr = temp;
//             count++;
//         }
        
//         return prevNode;
//     }



//     public ListNode reverseKGroup(ListNode head, int k) {
//         return reverse(head, k);
        

        
//     }
// }

class Solution {

    public ListNode reverse(ListNode head, int k) {
        if (head == null) return null;

        // Step 1: Check if there are at least k nodes
        ListNode itr = head;
        int count = 0;
        while (count < k && itr != null) {
            itr = itr.next;
            count++;
        }

        if (count < k) {
            // Not enough nodes for reversal — return as-is
            return head;
        }

        // Step 2: Recursively reverse the rest after k nodes
        ListNode restHead = reverse(itr, k);

        // Step 3: Reverse current group of k nodes
        ListNode prev = restHead;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4: prev now points to new head of this reversed segment
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }
}
