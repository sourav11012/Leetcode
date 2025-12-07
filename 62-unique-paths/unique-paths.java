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
        int dp[][] = new int[m][n];
        for(int[] temp : dp)
        {
            Arrays.fill(temp,-1);
        }
        int count = findPaths(0,0,new int[m][n],dp);
        return count;
    }
}