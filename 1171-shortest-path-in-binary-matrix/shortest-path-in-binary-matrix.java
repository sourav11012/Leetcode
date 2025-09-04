class Solution {
    class Node { 
        int first;
        int second;
        int distance;

        Node(int first, int second, int distance){
            this.first = first;
            this.second =second;
            this.distance = distance;
        }
        
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        q.add(new Node(0,0,1));
        visited[0][0] =1;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

        while(!q.isEmpty())
        {
            Node curr = q.peek();
            q.poll();
            if(curr.first == n - 1 && curr.second == m - 1) return curr.distance;

             for(int[] dir : dirs)
             {
                int newRow = curr.first + dir[0];
                int newCol = curr.second + dir[1];

                if(newRow < n && newRow >= 0 && newCol < m && newCol >= 0 && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 0)
                {
                    visited[newRow][newCol] =1;
                    q.add(new Node(newRow, newCol, curr.distance + 1));
                   
                }
             }
        }

        return -1;


    }
}