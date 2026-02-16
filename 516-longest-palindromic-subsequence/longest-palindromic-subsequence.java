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
        int dp[][]= new int[s.length()][s.length()];

        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return lcs(s, reversed,s.length()-1, s.length()-1, dp);
    }
}