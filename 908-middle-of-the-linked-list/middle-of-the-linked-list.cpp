/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        unordered_map<int, ListNode*> map;

        ListNode* curr = head;
        int idx = 0;
        while(curr)
        {
            map[idx++] = curr;
            curr = curr->next;
            
        }



        return map[map.size() / 2];
    }
};