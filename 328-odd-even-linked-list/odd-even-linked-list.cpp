class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (!head || !head->next) return head; // handle 0 or 1 node

        ListNode* odd = head;
        ListNode* even = head->next;
        ListNode* evenHead = even; // save starting point of evens

        while (even && even->next) {
            odd->next = even->next;
            odd = odd->next;

            even->next = odd->next;
            even = even->next;
        }

        // attach even list after odds
        odd->next = evenHead;
        return head;
    }
};
