class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int length = 1;
        while(temp.next != null)
        {
            temp =temp.next;
            length += 1;
        }
        temp.next = head;

        k = k % length;
        int steps= length - k - 1;
        ListNode tail = head;

        while(steps >0)
        {
            tail = tail.next;
            steps -= 1;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;




    }
}
