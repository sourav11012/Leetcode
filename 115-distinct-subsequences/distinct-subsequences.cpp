class Solution {
public:
    int fn(string& s, int i, string& t, int j,vector<vector<int>>& dp) {
    if(j < 0) return 1;       // t fully matched
    if(i < 0) return 0;       // s exhausted, t not matched

    if(dp[i][j] != -1) return dp[i][j];

    if(s[i] == t[j])
        return dp[i][j]= fn(s, i-1, t, j-1, dp) + fn(s, i-1, t, j,dp);
    else
        return dp[i][j]= fn(s, i-1, t, j,dp);
}


    int numDistinct(string s, string t) {
        int n = s.size();
        int m = t.size();
       

        vector<long long> prev(m+1, 0);
        vector<long long> curr(m+1, 0);
        prev[0] = 1;


        
        for(int i = 1;i<= n ;i++)
        {
            prev[0] = 1;
            for(int j = 1;j<= m;j++)
            {
                if(s[i - 1] == t[j - 1])
                    curr[j]= min((long long)INT_MAX, prev[j-1] + prev[j]);
                else
                   curr[j] = prev[j];
            }
            prev = curr;
        }
        return (int)prev[m];
    }
};