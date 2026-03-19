class Solution {
public:

    int fn(string& word1, string& word2, int i, int j, vector<vector<int>> & dp)
    {

        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1[i] == word2[j])
        {
            return dp[i][j]= fn(word1, word2, i - 1, j -1 , dp);
        }

        int del = 1 + fn(word1, word2, i -1,  j,dp);
        int replace = 1 + fn(word1, word2, i -1,  j -1,dp);
        int insert = 1 + fn(word1, word2, i,  j - 1,dp);

        return  dp[i][j]= min({del, replace, insert});

        


    }

    int minDistance(string word1, string word2) {
        int n = word1.size();
        int m = word2.size();

        //vector<vector<int>> dp(n + 1, vector<int>(m + 1, -1));
        vector<int> prev(m+1,0), curr(m+1,0);


        
        for(int i =0; i<= m;i++)
        {
            prev[i] = i ;
        }


        for(int i = 1 ;i <= n  ; i++)
        {
            curr[0] = i;
            for(int j = 1; j <= m ; j++)
            {
                if(word1[i - 1] == word2[j - 1])
                {
                    curr[j]= prev[j - 1];
                   
                }else{
                    int del = 1 + prev[j];
                    int replace = 1 + prev[j -1];
                    int insert = 1 + curr[j - 1];

                    curr[j]= min({del, replace, insert});
                }

                
            }
            prev = curr;

        }

        
        return prev[m];
        }
};