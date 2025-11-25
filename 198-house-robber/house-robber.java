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
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // Arrays.fill(dp, -1);
        for(int i = 2 ; i< n;i++)
        {
            int take = nums[i] + dp[i - 2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }
}