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

        ListNode* curr = headA;
        int sizeA = 0;
        int sizeB = 0;

        while(curr)
        {
            sizeA++;
            curr = curr->next;

        }
        curr = headB;
        while(curr)
        {
            sizeB++;
            curr = curr->next;

        }
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        if(sizeA > sizeB)
        {
            int skipA = sizeA - sizeB;
            while(skipA && tempA)
            {
                tempA = tempA->next;
                skipA--;
            }
        }else if(sizeA < sizeB){
        int skipB = sizeB - sizeA;
            while(skipB && tempB)
            {
                tempB = tempB->next;
                skipB--;
            }
        }
        while(tempA != tempB && tempB && tempA)
        {
            tempA = tempA->next;
            tempB = tempB->next;
        }
        if(tempA == tempB)
        {
            return tempA;
        }
       

        return nullptr;
    }
};