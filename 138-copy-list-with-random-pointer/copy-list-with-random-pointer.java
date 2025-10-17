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
        Node itr = head;
        Node dummy = new Node(-1);
        dummy = itr;
        Map<Node, Node> map = new HashMap<>();

        while(itr != null )
        {
            Node newNode = new Node(itr.val);
            map.put(itr , newNode);
            itr = itr.next;
        }

        itr = head;
        while(itr != null)
        {
            
            Node newNode = map.get(itr);

            newNode.next = map.get(itr.next);
            newNode.random = map.get(itr.random);

            itr = itr.next;
        }
        Node newHead = map.get(head);
        return newHead;

    }
}