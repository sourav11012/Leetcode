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
    bool isPalindrome(ListNode* head) {
        vector<int> value;

        ListNode* temp = head;

        while(temp)
        {
            value.push_back(temp->val);
            temp = temp->next;
        }

        int left = 0;
        int right = value.size()-1;

        while(left <= right)
        {
            if(value[left]!= value[right])
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
};