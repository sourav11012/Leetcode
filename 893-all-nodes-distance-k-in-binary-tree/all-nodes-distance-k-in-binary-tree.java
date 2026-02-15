/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> map)
    {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();

            if(curr.left!= null)
            {
                map.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right!= null)
            {
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return;


    }




    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        markParent(root, map);

        Set<TreeNode>vis =new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        vis.add(target);
        q.offer(target);
        int dis = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(dis == k) break;
            dis++;

            for(int i = 0;i<size; i++)
            {
                TreeNode curr = q.poll();

                if(curr.left != null && !vis.contains(curr.left))
                {
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right))
                {
                    q.offer(curr.right);
                    vis.add(curr.right);
                                    
                }

                if( map.get(curr)  != null && !vis.contains(map.get(curr)))
                {
                    q.offer(map.get(curr));
                    vis.add(map.get(curr));
                }

            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty())
        {
            result.add(q.poll().val);
        }
        return result;

    }
}