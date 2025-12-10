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
    record Pair(int height , boolean balanced)
    {};

    public Pair fn(TreeNode curr)
    {
        if(curr == null)
        {
            return new Pair(0, true);
        }

        Pair left = fn(curr.left);
        Pair right = fn(curr.right);

        int diff = left.height() - right.height();
        boolean balanced = left.balanced() && right.balanced() && Math.abs(diff) < 2;

        return new Pair(Math.max(left.height(), right.height())  +1, balanced);
    }
    public boolean isBalanced(TreeNode root) {
        return fn(root).balanced();

    }
}