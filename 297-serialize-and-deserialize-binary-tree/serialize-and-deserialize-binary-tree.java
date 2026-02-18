/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if(root ==null) return "";
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(curr.val + " ");

            q.offer(curr.left);
            q.offer(curr.right);

            
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;

        String[] values =data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i = 1; i<values.length; i++)
        {
            TreeNode curr = q.poll();
            if(!values[i].equals("n"))
            {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.left);
            }

            if(!values[++i].equals("n")){
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.right);
            }

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));