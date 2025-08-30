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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head) return nullptr;
        int size= 0;

        ListNode* itr = head;

        while(itr != NULL)
        {
             size++;
            itr = itr->next;
           
        }

if (n == size) {
            return head->next;
        }
itr = head;
      
        size = size - n - 1;
        
        while(size)
        {
            itr = itr->next;
            size--;
        }
      
        itr->next = itr->next->next;

        return head;

    }
};