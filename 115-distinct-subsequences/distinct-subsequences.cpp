class Solution {
public:
    int fn(string& s, int i, string& t, int j,vector<vector<int>>& dp) {
    if(j < 0) return 1;       // t fully matched
    if(i < 0) return 0;       // s exhausted, t not matched

    if(dp[i][j] != -1) return dp[i][j];

    if(s[i] == t[j])
        return dp[i][j]= fn(s, i-1, t, j-1, dp) + fn(s, i-1, t, j,dp);
    else
        return fn(s, i-1, t, j,dp);
}


    int numDistinct(string s, string t) {
        int n = s.size();
        int m = t.size();
        vector<vector<int>> dp (n, vector<int>(m,-1));
        return fn(s, n-1, t, m-1 ,dp);
    }
};