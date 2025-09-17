class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second)
        {
            this.first = first;
            this.second= second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int n = image.length;
        int m = image[0].length;
        int currColor = image[sr][sc];
        q.add(new Pair(sr,sc));
        int[][] visited = new int[image.length][image[0].length];
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        visited[sr][sc] = 1;
        image[sr][sc] = color;

        while(!q.isEmpty())
        {
            Pair curr = q.poll();
           
           
            for(int[] dir : dirs)
            {
                 int newRow = curr.first + dir[0];
            int newCol = curr.second + dir[1];

                if(newRow < n && newRow >= 0 && newCol < m && newCol >=0 && image[newRow][newCol] == currColor && visited[newRow][newCol] != 1)
                {
                    image[newRow][newCol] = color;
                    visited[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        

        return image;

    }
}