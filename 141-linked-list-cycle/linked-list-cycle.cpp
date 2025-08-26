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
    bool hasCycle(ListNode *head) {
        // ListNode* slow = head;
        // ListNode* fast = head;
        unordered_set<ListNode*> set;
        ListNode* curr = head;
        while(curr != nullptr)
        {
            if(set.count(curr))
            {
                return true;
            }
            set.insert(curr);
            curr = curr->next;
        }

        return false;
    }
};