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
    public int findHeight(TreeNode curr)
    {
        if(curr == null)
        {
            return 0;
        }
        return Math.max(findHeight(curr.left), findHeight(curr.right))  +1;
    }

    void traverse(Queue<TreeNode> q , TreeNode root)
    {
        if(root == null) return;

        traverse(q, root.left);
        q.offer(root);
        traverse(q, root.right);

    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();

        traverse(q, root);
        int maxDiameter = Integer.MIN_VALUE;
            while(!q.isEmpty())
            {
            TreeNode curr = q.poll();
            int left = findHeight(curr.left);
            int right = findHeight(curr.right);
            maxDiameter = Math.max(left + right, maxDiameter);
            }

            return maxDiameter;
           
     
       




    }
}