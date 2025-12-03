class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        record Pair(int row, int col){};
        int n = image.length;
        int m = image[0].length;

        int visited[][] = new int[n][m];
        visited[sr][sc] = 1;

        Queue<Pair> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        q.offer(new Pair(sr,sc));
        int prevColor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            for(int dir[] : dirs)
            {
                int newCol = curr.col() + dir[0];
                int newRow = curr.row() + dir[1];

                if(newCol < m && newRow < n && newCol >= 0 && newRow >= 0 && visited[newRow][newCol] == 0 && image[newRow][newCol] == prevColor)
                {
                    image[newRow][newCol] = color;
                    visited[newRow][newCol] = 1;
                    q.offer(new Pair(newRow, newCol));
                }
            }

        }

        return image;
    }
}