class Solution {

    public int fn(int[] nums, int idx, int[] dp)
    {
        if(idx >= nums.length -1)
        {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        int count = (int)1e9;
        for(int i = nums[idx] ; i>=1 ; i--)
        {
            count = Math.min(count, 1 + fn(nums, i + idx,dp));
        }
        dp[idx] = count;
        return dp[idx];

    }


    public int jump(int[] nums) {
         int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return fn(nums, 0,dp);
    }
}