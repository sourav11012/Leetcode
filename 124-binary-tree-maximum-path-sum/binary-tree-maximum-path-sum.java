class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int findMaxSum(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        // Ignore negative paths
        int leftSum = Math.max(0, findMaxSum(curr.left));
        int rightSum = Math.max(0, findMaxSum(curr.right));

        // Path passing through current node
        int currMaxSum = curr.val + leftSum + rightSum;

        // Update global maximum
        maxSum = Math.max(maxSum, currMaxSum);

        // Return max path going UP (only one side allowed)
        return curr.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }
}
