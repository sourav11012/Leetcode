class Solution {
public:
    void dfs(vector<vector<char>>& grid, vector<vector<int>>& visited, int row, int col) {
        int n = grid.size();
        int m = grid[0].size();

        // Boundary and visited checks
        if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col] == 1 || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = 1;

        // Directions: right, down, left, up
        int dirs[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};

        for (auto dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, visited, newRow, newCol);
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        if (n == 0) return 0;
        int m = grid[0].size();

        vector<vector<int>> visited(n, vector<int>(m, 0));
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }
};
