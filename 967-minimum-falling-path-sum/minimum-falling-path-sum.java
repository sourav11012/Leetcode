class Solution {

    private int minSum(int[][] matrix, int i , int j,int[][]dp)
    {
        
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m) return Integer.MAX_VALUE;
        
        if(i == n - 1 )
        {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = minSum(matrix, i+1, j,dp);
        int downLeft = minSum( matrix, i+1, j-1,dp);
        int downRight =minSum(matrix, i+1, j+1,dp);

        dp[i][j] =  matrix[i][j] + Math.min(Math.min(downLeft, downRight), down);
        return dp[i][j];

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int i =0 ;i<m;i++)
        {
            min = Math.min(min, minSum(matrix, 0,i,dp));
        }
        return min;
    }
}