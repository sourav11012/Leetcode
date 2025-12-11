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
    int maxDiameter = Integer.MIN_VALUE;
    public int findHeight(TreeNode curr)
    {
        if(curr == null)
        {
            return 0;
        }
        int left = findHeight(curr.left);
        int right = findHeight(curr.right);
        maxDiameter = Math.max(left + right, maxDiameter);

        return Math.max(left,right)  +1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        findHeight(root);
       

        return maxDiameter;
           
     
       




    }
}