class Solution {

    private boolean fn(int[] nums, int idx, int sum, Boolean[][] dp)
    {
        if (sum == 0) return true;
        if (idx >= nums.length) return false;

        if (dp[idx][sum] != null) return dp[idx][sum];

        boolean pick = false;
        if (nums[idx] <= sum) {
            pick = fn(nums, idx + 1, sum - nums[idx], dp);
        }

        boolean notPick = fn(nums, idx + 1, sum, dp);

        return dp[idx][sum] = pick || notPick;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        if (total % 2 == 1) return false;

        int target = total / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return fn(nums, 0, target, dp);
    }
}
