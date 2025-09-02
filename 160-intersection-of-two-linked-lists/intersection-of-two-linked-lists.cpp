/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        unordered_set<ListNode*> set;

        ListNode* curr = headA;
        while(curr)
        {
            set.insert(curr);
            curr = curr->next;

        }

        curr = headB;

        while(curr)
        {
            if(set.find(curr) != set.end())
            {
                return curr;
            }
            curr= curr->next;
        }

        return nullptr;
    }
};