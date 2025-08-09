class Solution {
public:

    int fn(int idx, vector<int>& coins, int amount, vector<vector<int>>& dp)
    {
        if(amount == 0) return 0;
        if(amount < 0 || idx == coins.size()) return INT_MAX; 
        if(dp[idx][amount] != -1 )return dp[idx][amount];
         int take = fn(idx, coins, amount - coins[idx],dp);
        if(take != INT_MAX) take += 1;
        int notTake = fn(idx + 1, coins, amount,dp);

        return dp[idx][amount] = min(take, notTake);


    }



    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int>(amount + 1, -1));
        int ans= fn(0, coins, amount,dp);
        return ans == INT_MAX ? -1 :ans;
    }
};