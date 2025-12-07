class Solution {
    public int findPaths(int[][] grid, int i, int j, int endi , int endj,int[][]dp)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(i == endi && j == endj)
        {
            return 1;
        }
        if(i >= m || j >= n || j<0 || i<0 || grid[i][j] == 1)
        {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        grid[i][j] = 1;

        int[][] dirs = new int[][]{{1,0},{0,1}};
        int count = 0;
        for(int[] dir : dirs)
        {
            int nr = i + dir[0];
            int nc = j + dir[1];
            count = count + findPaths(grid,nr,nc,endi, endj,dp);
            
        }
        grid[i][j] = 0;
        dp[i][j] = count;
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int dp[][] = new int[m][n];

        for(int[] temp : dp)
        {
            Arrays.fill(temp,-1);
        }

        int totalPaths = findPaths(grid,0,0,m-1,n-1 ,dp);
        return totalPaths;
    }
}