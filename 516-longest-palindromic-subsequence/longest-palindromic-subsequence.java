class Solution {

    private int lcs(String s1, String s2, int idx1, int idx2,int[][] dp)

    {
        if(idx1 < 0 || idx2 < 0)
        {
            return 0;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1) == s2.charAt(idx2))
        {
            dp[idx1][idx2] =  1 + lcs(s1, s2, idx1-1, idx2-1,dp);
            return dp[idx1][idx2];
        }

        dp[idx1][idx2] =  Math.max(lcs(s1, s2, idx1-1, idx2,dp), lcs(s1, s2, idx1 , idx2-1,dp));
       
        return dp[idx1][idx2];
    }

    public int longestPalindromeSubseq(String s) {
        
        String reversed = new StringBuilder(s).reverse().toString();
        int dp[][]= new int[s.length() + 1][s.length() + 1];


        for(int idx1 = 0 ; idx1 <= s.length(); idx1++)
        {
            for(int idx2 = 0 ; idx2 <= reversed.length() ; idx2++)
            {
                if(idx1 == 0 || idx2==0)
                {
                   
                    continue;
                }
                
                 if(s.charAt(idx1 - 1) == reversed.charAt(idx2 - 1))
                {
                    dp[idx1][idx2] =  1 + dp[idx1-1][ idx2-1];
                    
                }
                else dp[idx1][idx2] =  Math.max(dp[idx1-1][idx2], dp[idx1] [idx2-1]);
            
                
            }
        }
        
        return dp[s.length()][ s.length()];
    }
}