class Solution {

    class Pair {
        int r, c, dist;

        Pair(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // start or end blocked
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));

        // mark visited
        grid[0][0] = 1;

        int[][] dirs = {
                {0,1},{1,0},{1,1},
                {-1,-1},{0,-1},{-1,0},
                {-1,1},{1,-1}
        };

        while(!q.isEmpty()){

            Pair curr = q.poll();

            if(curr.r == n-1 && curr.c == n-1)
                return curr.dist;

            for(int[] d : dirs){

                int nr = curr.r + d[0];
                int nc = curr.c + d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0){

                    q.offer(new Pair(nr, nc, curr.dist+1));
                    grid[nr][nc] = 1; // mark visited
                }
            }
        }

        return -1;
    }
}
