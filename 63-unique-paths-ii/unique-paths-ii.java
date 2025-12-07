class Solution {

    public int fn(int[][] grid, int i,int j ,int[][] dp)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || grid[i][j] == 1 ) return 0;
        if(i == 0 && j == 0) return 1;
       
        if(dp[i][j] != -1) return dp[i][j];

        int left = fn(grid, i , j -1,dp);
        int up = fn(grid, i-1, j,dp);
        dp[i][j] = left+ up;
        return dp[i][j];
       
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];

        // for(int[] temp : dp)
        // {
        //     Arrays.fill(temp,-1);
        // }

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int left = 0; int up = 0;
                    if(j > 0) left = dp[i][j -1];
                    if(i > 0) up = dp[i-1][j];
                    dp[i][j] = left+ up;
                }
                    
            }
        }
        // return fn(obstacleGrid,n-1, m-1,dp);
       return  dp[n-1][m-1];
    }
}