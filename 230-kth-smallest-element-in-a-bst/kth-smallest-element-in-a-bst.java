/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

PriorityQueue<Integer> pq = new PriorityQueue<>();
    public void iterate(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        pq.offer(root.val);
        iterate(root.right);
        iterate(root.left);

    }
    public int kthSmallest(TreeNode root, int k) {
        

        iterate(root);
        int minVal = -1;
        for(int i = 0;i<k;i++)
        {
            minVal = pq.poll();
        }
        return minVal;
    }
}