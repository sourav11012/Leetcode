class Solution {

    public int fn(int[] nums, int idx, int[] dp)
    {
        if(idx < 0) return 0;
        if(dp[idx] !=-1) return dp[idx];


        int take = nums[idx] + fn(nums, idx - 2,dp);
        int notTake = fn(nums, idx-1,dp);
        dp[idx] = Math.max(take, notTake);
        return dp[idx];
    }



    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return fn(nums, nums.length - 1,dp);
    }
}