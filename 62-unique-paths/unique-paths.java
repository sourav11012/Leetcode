class Solution {
    public int findPaths(int i , int j, int[][] grid ,int[][]dp)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(i == m - 1&& j == n - 1) return 1;

        if(i >= m || j >=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int right = findPaths(i ,j + 1,grid,dp);
        int down = findPaths(i + 1, j, grid,dp);
        dp[i][j] = right + down;
        return dp[i][j];
    }



    public int uniquePaths(int m, int n) {
       

        
        int[] prev = new int[n];

        for(int i = m-1;i>=0;i--)
        {
            int[] curr = new int[n];
            for(int j = n-1; j>=0;j--)
            {
                
                if(j == n-1 && i == m-1) curr[n-1] = 1; 
                else{
                    int right = 0;
                    int down =0;
                    if(j < n-1) right= curr[j + 1];
                    if(i < m-1) down = prev[j];
                     curr[j] = right + down;

                }
               
            }
            prev = curr;
        }
      
        return prev[0];
    }
}