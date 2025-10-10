class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Store nodes in a map and find the length
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            map.put(length, temp);
            temp = temp.next;
            length++;
        }

        // Step 2: Normalize k
        k = k % length;
        if (k == 0) return head;

        // Step 3: Find the break point
        int breakPoint = length - k - 1;

        // Step 4: Reconnect nodes
        ListNode last = map.get(breakPoint);
        ListNode newHead = last.next;
        last.next = null;

        // The previous last node becomes connected to the old head
        ListNode join = map.get(length - 1);
        join.next = head;

        return newHead;
    }
}
