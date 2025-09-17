class Solution {
    private int minCoin(int idx, int[] coins, int amount , int[][]dp)
    {
       
        if(idx < 0){
            if(amount == 0) return 0;
            else return (int)1e9;
        }
        if(amount == 0) return 0;
        if(dp[idx][amount + amount] != -1) return dp[idx][amount + amount];
        int pick = (int)1e9;
        if(amount >= coins[idx])
        {
            pick = 1 + minCoin(idx, coins, amount - coins[idx],dp);
        }
        
        int notPick = minCoin(idx - 1, coins, amount, dp);

         dp[idx][amount +amount] = Math.min(pick, notPick);
         return dp[idx][amount + amount];


    }


    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount * 2 + 1];
        for(int[] arr : dp)
        Arrays.fill(arr,-1);
        int result = minCoin(coins.length - 1, coins, amount, dp);
        return  result ==  (int)1e9 ? -1 : result;
    }
}