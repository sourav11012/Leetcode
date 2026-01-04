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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        boolean flag = true;

        while(!q.isEmpty())
        {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n ;i++)
            {
            
            TreeNode curr = q.poll();
            temp.add(curr.val);
            if(curr.left != null) {
                q.offer(curr.left);
            }
            if(curr.right != null) {
                q.offer(curr.right);
            }
            }
            if(flag)
            {
            result.add(temp);
            flag = false;
            }else{
             Collections.reverse(temp);
             result.add(temp);
             flag = true;
            }

            
               

        }
        return result;

    }
}