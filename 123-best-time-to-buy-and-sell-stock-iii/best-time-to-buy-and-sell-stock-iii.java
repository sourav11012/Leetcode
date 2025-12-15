class Solution {
        public int fn(int[] prices, int idx, int flag,int cap, int[][][]dp)
    {
        if(idx == prices.length || cap == 0)
        {
            return 0;
        }
        if(dp[idx][flag][cap] != -1) return dp[idx][flag][cap];

        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        if(flag == 1)
        {
            buy = -prices[idx] + fn(prices, idx + 1, 0 ,cap, dp);
        }else{
            sell = prices[idx] + fn(prices, idx + 1, 1, cap - 1, dp);
        }
        int skip = fn(prices, idx + 1,flag,cap,dp);
        dp[idx][flag][cap]= Math.max(Math.max(buy, sell), skip);

        return dp[idx][flag][cap];
    }

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];

        for(int i = 0 ; i<prices.length ;i++)
        {
            for(int j = 0;j<2;j++)
            {
                for(int k = 0;k<3 ;k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fn(prices, 0, 1, 2, dp);
    }
}