class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (!head) return nullptr;

        // Step 1: find length
        int size = 0;
        ListNode* itr = head;
        while (itr) {
            size++;
            itr = itr->next;
        }

        // If removing head
        if (n == size) {
            return head->next;
        }

        // Step 2: find node before target
        itr = head;
        for (int i = 1; i < size - n; i++) {
            itr = itr->next;
        }

        // Step 3: remove target node
        itr->next = itr->next->next;

        return head;
    }
};
