class Solution {

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void dfs(int row, int col, int[][] visited, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
            visited[row][col] == 1 || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = 1;

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], visited, grid);
        }
    }

    private int bfs(int[][] visited, int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == 1) q.offer(new Pair(i, j));
            }
        }

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                for (int[] dir : directions) {
                    int newRow = curr.row + dir[0];
                    int newCol = curr.col + dir[1];

                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || visited[newRow][newCol] == 1)
                        continue;

                    if (grid[newRow][newCol] == 1)
                        return distance;

                    visited[newRow][newCol] = 1;
                    q.offer(new Pair(newRow, newCol));
                }
            }
            distance++;
        }
        return distance;
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, visited, grid);
                    return bfs(visited, grid);
                }
            }
        }

        return 0;
    }
}
