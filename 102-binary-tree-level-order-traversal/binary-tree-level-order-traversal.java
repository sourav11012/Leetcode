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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null ) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<TreeNode> temp2 = new ArrayList<>();
            while(!q.isEmpty())
            {
            TreeNode curr = q.poll();
            temp.add(curr.val);
            temp2.add(curr);
            }

            for(TreeNode tn : temp2)
            {
                if(tn.left != null)
                    q.add(tn.left);
                if(tn.right != null)
                    q.add(tn.right);
            }
            result.add(new ArrayList<>(temp));
            temp.clear();
            temp2.clear();
        }

        return result;
    }
}