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

    public boolean fn(TreeNode left, TreeNode right)
    {
        if(left == null && right == null )
        {
            return true;
        }
        Integer leftVal= null;
        Integer rightVal = null;
        if(left != null)
        {
            leftVal = left.val;
        }

        if(right != null )
        {
            rightVal =right.val;
        }

        if(leftVal != rightVal)
        {
            return false;
        }

        boolean l1 = fn(left.left, right.right);
        boolean l2 = fn(left.right, right.left);

        return l1 && l2;


    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;


        return fn(root.left, root.right);
    }
}