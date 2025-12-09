class Solution {

    private int fn(List<List<Integer>> triangle, int i , int j,int[][]dp)
    {
        int n = triangle.size();
        if(i == n - 1 )
        {
            return triangle.get(i).get(j);
        }
        
        if(dp[i][j]  != -1) return dp[i][j];
        
        int down = triangle.get(i).get(j) + fn(triangle, i + 1, j, dp);

        int downRight =  triangle.get(i).get(j)  + fn(triangle, i + 1, j + 1, dp);
  

       dp[i][j] = Math.min(down, downRight);
        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
            // Arrays.fill(dp[i], -1);
        }
       


        for(int i = n-1; i>=0;i--)
        {
            int m = dp[i].length;
            for(int j = i; j>=0; j--)
            {
                if(i == n-1)
                { 
                dp[i][j]= triangle.get(i).get(j);
                }else{      
                    int down = triangle.get(i).get(j) + dp[i + 1][ j];
                    int downRight = triangle.get(i).get(j)  + dp[i + 1][ j + 1];
                    dp[i][j] = Math.min(down, downRight);
                }
               
            }
        }

        return dp[0][ 0];
    }
}
