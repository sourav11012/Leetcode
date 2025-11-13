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

    private void func(TreeNode root, List<Integer> result)
    {
        if(root == null) return;
        if(root.right == null && root.left == null) {
            result.add(root.val); return;
        }

        func(root.left, result);
        result.add(root.val);  
        func(root.right, result);
        return;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        func(root, result);
        return result;
    }
}