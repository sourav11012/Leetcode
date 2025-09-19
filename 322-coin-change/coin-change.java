class Solution {

    private int fn(int idx, int[] coins, int amount,int[][] dp){

        if(idx == 0)
        {
            if(amount % coins[idx] == 0) return amount / coins[idx];
            else return (int)1e9;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notPick = fn(idx - 1, coins, amount,dp);
        int pick = (int)1e9;
        if(amount >= coins[idx])
        {
            pick = 1 + fn(idx , coins, amount - coins[idx],dp);
        }
        dp[idx][amount] = Math.min(pick , notPick);
        return dp[idx][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[][]dp =new int[coins.length][amount+1];
        for(int[] arr :dp)
        Arrays.fill(arr, -1);
        int ans = fn(coins.length - 1, coins, amount,dp);
        return (ans == (int)1e9) ? -1 : ans;
    }
}