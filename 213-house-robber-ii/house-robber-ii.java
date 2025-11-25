class Solution {
      public int rob1(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[nums.length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        // Arrays.fill(dp, -1);
        for(int i = 2 ; i< n;i++)
        {
           
            int take = nums[i] + prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
       if(nums.length ==1 ) return nums[0];
        int[] lastIn = Arrays.copyOfRange(nums, 1, nums.length);
        int[] firstIn = Arrays.copyOfRange(nums, 0, nums.length-1);

        
        return Math.max(rob1(firstIn), rob1(lastIn));
    }
}