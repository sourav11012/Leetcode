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
     int result = -1;
     int k ;
    public void inorder(TreeNode root)
    {
       if(root != null)
       {
        inorder(root.left);
        if(--k == 0)
        {
            result = root.val;
            return ;
        }
        inorder(root.right);
       }
    } 
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> list = new ArrayList<>();
       this.k = k;
        inorder(root);
        return result;
    }
}