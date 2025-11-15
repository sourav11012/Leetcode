class Solution {
    public int orangesRotting(int[][] grid) {
        record Pair(int row, int col, int time){};
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        Queue<Pair>  q = new LinkedList<>();

        for(int i = 0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                   q.add(new Pair(i,j,0));
                   visited[i][j] = true;
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int count = 0;
        while(!q.isEmpty())
        {
            Pair currOrange = q.poll();
            count = currOrange.time();
            

            for(int[] dir : dirs)
            {
                int newRow = currOrange.row() + dir[0];
                int newCol = currOrange.col() + dir[1];
                

                if(newRow < n && newCol < m && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] == 1 && visited[newRow][newCol] != true)
                {
                    visited[newRow][newCol] = true;
                    grid[newRow][newCol] = 2;
                    q.offer(new Pair(newRow, newCol, currOrange.time() + 1));
                }
            }
            
        }

        for(int i = 0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                  return -1;
                }
            }
        }
        return count;
    }
}