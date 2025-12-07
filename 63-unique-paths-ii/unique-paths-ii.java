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

        for(int[] temp : dp)
        {
            Arrays.fill(temp,-1);
        }
        return fn(obstacleGrid,n-1, m-1,dp);
    }
}