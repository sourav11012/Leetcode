/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        ListNode curr =headA;
        while(curr!= null)
        {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;

        while(curr != null)
        {
            if(set.contains(curr))
            {
                return curr;
            }
            curr=curr.next;
        }

        return null;







        // unordered_set<ListNode*> set;

        // ListNode* curr = headA;
        // while(curr)
        // {
        //     set.insert(curr);
        //     curr = curr->next;

        // }

        // curr = headB;

        // while(curr)
        // {
        //     if(set.find(curr) != set.end())
        //     {
        //         return curr;
        //     }
        //     curr= curr->next;
        // }

        // return new ListNode(-1);
    }
}