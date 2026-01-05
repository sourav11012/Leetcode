/**
 * @param {number} capacity
 */
class Node{
    constructor(key,value)
    {
        this.key = key;
        this.value =value;
        this.next = null;
        this.prev = null;
    }
    

}
var LRUCache = function(capacity) {
    
    this.capacity = capacity;
    this.map = new Map();

    // Dummy head & tail (sentinels)
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);

    this.head.next = this.tail;
    this.tail.prev = this.head;
}; 

LRUCache.prototype.remove = function(node)
{
    node.next.prev = node.prev;
    node.prev.next = node.next;
}
LRUCache.prototype.insertAtFront = function(node)
{
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next.prev = node;
    this.head.next = node;

}
/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if(!this.map.has(key))
    {
        return -1;
    }
    // const node = new Node(key,value);
    // this.map.set(key, node);
    const node = this.map.get(key);
    this.remove(node);
    this.insertAtFront(node);
    return node.value;


};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if(this.map.has(key))
    {
        const node = this.map.get(key);
        this.remove(node);
        node.value = value;
        this.insertAtFront(node);
        return ;
    }

    const node = new Node(key, value);
    this.map.set(key, node);
    this.insertAtFront(node);

    if(this.map.size > this.capacity)
    {
        const node = this.tail.prev;
        this.remove(node);
        this.map.delete(node.key);
        return;
    }
    
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */