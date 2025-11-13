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

    // private void func(TreeNode root, List<Integer> result)
    // {
    //     if(root == null) return;
    //     if(root.right == null && root.left == null) {
    //         result.add(root.val); return;
    //     }

    //     result.add(root.val);
    //     func(root.left, result);
    //     func(root.right, result);
    //     return;
    // }


    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        List<Integer> result = new ArrayList<>();

        st.add(root);

        while(!st.isEmpty())
        {

            TreeNode curr = st.pop();

            result.add(curr.val);

            if(curr.right != null)
                st.add(curr.right);

            if(curr.left != null)
                st.add(curr.left);

        }

        // func(root, result);
        return result;
    }
}