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
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int idx = n-1; idx>=0;idx--)
        {
            
            for(int flag = 0 ;flag <=1;flag++)
            {
                int buy = Integer.MIN_VALUE;
                int sell = Integer.MIN_VALUE;
                if(flag == 1)
                {
                    buy = -prices[idx] + ahead[0]; // dp[idx+1][0];
                }else{
                    sell = prices[idx] + ahead[1]; // dp[idx+1][0];
                }
                int skip = ahead[flag]; // dp[idx+1][flag]
                curr[flag]= Math.max(Math.max(buy, sell), skip); // dp[idx][flag]

            }
            ahead = curr;
        }
        return ahead[1];
        // return fn(prices, 0 , 1,dp);
    }
}