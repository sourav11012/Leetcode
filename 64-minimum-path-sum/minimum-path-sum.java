class Solution {
    public int fn(int[][] grid, int i, int j,int[][] dp )
    {

        if(i ==0 && j ==0 )return  grid[0][0];

        if(i < 0 || j< 0 )return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int left =  fn(grid, i, j-1,dp);
        int up =  fn(grid, i - 1,j,dp);

        dp[i][j] = grid[i][j] +  Math.min(left, up);
        return dp[i][j];


    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int[] temp : dp)
            Arrays.fill(temp,-1);

        return fn(grid,n-1,m-1, dp);
    }
}