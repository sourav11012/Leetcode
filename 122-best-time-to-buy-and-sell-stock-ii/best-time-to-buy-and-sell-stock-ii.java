class Solution {
    public int fn(int[] prices, int idx, int flag,Integer[][]dp)
    {
        if(idx == prices.length)
        {
            return 0;
        }
        if(dp[idx][flag] != null) return dp[idx][flag];

        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        if(flag == 1)
        {
            buy = -prices[idx] + fn(prices, idx + 1, 0 ,dp);
        }else{
            sell = prices[idx] + fn(prices, idx + 1, 1,dp);
        }
        int skip = fn(prices, idx + 1,flag,dp);
        dp[idx][flag]= Math.max(Math.max(buy, sell), skip);

        return dp[idx][flag];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][]dp = new int[n+1][2];
        // for(Integer [] row : dp)
        // {
        //     Arrays.fill(row, null);
        // }
        for(int idx = n-1; idx>=0;idx--)
        {
            for(int flag = 0 ;flag <=1;flag++)
            {
                int buy = Integer.MIN_VALUE;
                int sell = Integer.MIN_VALUE;
                if(flag == 1)
                {
                    buy = -prices[idx] + dp[idx + 1][0];
                }else{
                    sell = prices[idx] + dp[idx + 1][1];
                }
                int skip = dp[idx + 1][flag];
                dp[idx][flag]= Math.max(Math.max(buy, sell), skip);

            }
        }
        return dp[0][1];
        // return fn(prices, 0 , 1,dp);
    }
}