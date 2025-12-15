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
        int[][][] dp = new int[prices.length + 1][2][3];
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for(int idx = prices.length - 1 ; idx>=0; idx--)
        {
            for(int flag = 0;flag<2;flag++)
            {
                for(int cap = 1;cap<3 ;cap++)
                {
                    int buy = Integer.MIN_VALUE;
                    int sell = Integer.MIN_VALUE;
                    if(flag == 1)
                    {
                        buy = -prices[idx] + ahead[ 0 ][cap];
                    }else{
                        sell = prices[idx] + ahead[1][cap - 1];
                    }
                    int skip = ahead[flag][cap];
                    curr[flag][cap]= Math.max(Math.max(buy, sell), skip);

                }
                ahead = curr;
            }

        }

        return ahead[ 1][2];
    }
}