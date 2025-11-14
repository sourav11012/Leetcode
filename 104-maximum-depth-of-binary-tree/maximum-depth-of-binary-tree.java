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

    public int dfs(TreeNode root)

    {
        if(root == null)
        {
            return 0;
        }

        int depth = (int)-1e9;

        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        depth = Math.max(depth, Math.max(left, right));
        return depth;
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
}