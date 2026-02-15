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
    public class Pair{
        int idx;
        TreeNode node;
        public Pair(TreeNode node, int idx)
        {
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        

        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int min = q.peek().idx;
            int first = 0;
            int last = 0;

            for(int i = 0;i < size;i++)
            {
                int currId = q.peek().idx - min;
                TreeNode curr = q.poll().node;

                if(i == 0) first = currId;
                if(i == size - 1) last = currId;

                if(curr.left!= null) q.offer(new Pair(curr.left, 2 * currId + 1));
                if(curr.right != null) q.offer(new Pair(curr.right , 2 * currId + 2));

            }

            ans = Math.max(ans , last - first + 1);
            
        }

        return ans;
    }
}