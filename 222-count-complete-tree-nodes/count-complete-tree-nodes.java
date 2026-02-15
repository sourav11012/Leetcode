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
    public int cn(TreeNode root)
    {
        int left = 0;
        if(root.left != null)
        {
         left = countNodes(root.left);
        }
        int right = 0;
        if(root.right != null)
        {
            right = countNodes(root.right);
        }

        return 1 + left + right;

    }
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;

        return cn(root);
        
    }
}