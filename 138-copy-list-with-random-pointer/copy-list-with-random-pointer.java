/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node itr = head;
        Node dummy = new Node(-1);

        while(itr != null)
        {
            Node newNode = new Node(itr.val);

            Node temp = itr.next;
            itr.next = newNode;
            newNode.next = temp;
            itr = temp;

        }
        Node newHead = head.next;
        itr = head;
        while(itr != null)
        {
            Node temp  = itr.next.next;
            // Node nextNewNode = itr.next.next != null ? itr.next.next.next : null;
            Node randomNewNode = itr.random != null ? itr.random.next : null;
            // itr.next.next = nextNewNode;
            itr.next.random = randomNewNode;
            itr = temp;

        }
        itr = head;
        while(itr != null)
        {
            Node temp = itr.next.next;
            Node newNode = itr.next;
            Node nextNewNode = itr.next.next != null ? itr.next.next.next : null;
            
            itr.next = itr.next.next;
            newNode.next = nextNewNode;
            itr = temp;




        }
        return newHead;
    }
}