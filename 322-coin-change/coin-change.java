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
        // for(int[] arr :dp)
        // Arrays.fill(arr,-1);
        for(int i = 0; i <= amount ;i++)
        {
            if(i % coins[0] ==0 ){
                dp[0][i] = i /coins[0];
            }else {
                dp[0][i] = (int) 1e9;
            }
        }

        for(int i = 1;i<coins.length ; i++)
        {
            for(int t = 0 ;t<=amount;t++)
            {
            
            int notPick = dp[i - 1][t];

            int pick = (int)1e9;
            if(t >= coins[i])
            {
                pick = 1 + dp[i][t - coins[i]];
            }
            dp[i][t] = Math.min(pick , notPick);

            }
        }





        int ans = dp[coins.length - 1][amount];
        return (ans == (int)1e9) ? -1 : ans;
    }
}