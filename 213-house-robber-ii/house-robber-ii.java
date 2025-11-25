class Solution {
     public int rob1(ArrayList<Integer> nums) {
        int n = nums.size();

        if(n == 0) return 0;
        if(n == 1) return nums.get(0);
        if(n == 2) return Math.max(nums.get(0), nums.get(1));

        int dp[] = new int[n];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        int prev2 = nums.get(0);
        int prev1 = Math.max(nums.get(0), nums.get(1));
        // Arrays.fill(dp, -1);
        for(int i = 2 ; i< n;i++)
        {
           
            int take = nums.get(i) + prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        ArrayList<Integer> firstIn= new ArrayList<>();
        ArrayList<Integer> lastIn = new ArrayList<>();
        if(nums.length == 1) return nums[0];
        for(int i = 0 ;i <nums.length;i++)
        {
            if(i != 0) lastIn.add(nums[i]);
            if( i != nums.length - 1) firstIn.add(nums[i]);
        }
        return Math.max(rob1(firstIn), rob1(lastIn));
    }
}