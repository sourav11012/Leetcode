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
    public class Tuple{

        TreeNode node;
        int x;
        int y;

        Tuple(TreeNode node, int x, int y)
        {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0,0));


        while(!q.isEmpty())
        {
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int x = curr.x;
            int y = curr.y;

            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if(node.right != null)
            {
                q.offer(new Tuple(node.right, x+ 1, y+1));
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        for(int row : map.keySet())
        {
            TreeMap<Integer, PriorityQueue<Integer>> temp = map.get(row);
           List<Integer> tempList = new ArrayList<>();
            for(int col : temp.keySet() )
            {
                PriorityQueue<Integer> pq = temp.get(col);
                
                while(!pq.isEmpty())
                {
                    tempList.add(pq.poll());
                }
                 
            }
            result.add(tempList);
           
        }

        return result;
    }
}