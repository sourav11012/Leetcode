class Solution {
public:
     static const inline vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    void dfs(vector<vector<char>>& board, int row, int col, vector<vector<bool>>& visited)
    {
        int n = board.size();
        int m = board[0].size();
        

       

        for(vector<int> dir : dirs)
        {
            int newRow = row+ dir[0];
            int newCol = col + dir[1];

            if(newRow < n && newRow >= 0 && newCol < m && newCol >=0 &&!visited[newRow][newCol] && board[newRow][newCol] == 'O')
            {
                visited[newRow][newCol] = true;
                dfs(board, newRow, newCol, visited);
            }
        }
        return ;
    }



    void solve(vector<vector<char>>& board) {
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        int n = board.size();
        int m = board[0].size();
        for(int i =0 ; i<m ;i++)
        {
            if(!visited[0][i] && board[0][i] == 'O')
            {
                 visited[0][i] = true;
                dfs(board, 0, i, visited);
            }
            
        }
        for(int i =0 ; i<m ;i++)
        {
            if(!visited[n-1][i] && board[n-1][i] == 'O')
            {
                visited[n-1][i] = true;
                dfs(board, n-1, i, visited);
            }
            
        }
        for(int i =1 ; i<n-1 ;i++)
        {
            if(!visited[i][0] && board[i][0] == 'O')
            {
                visited[i][0] = true;
                dfs(board, i, 0, visited);
            }
            
        }
        for(int i =1 ; i<n-1 ;i++)
        {
            if(!visited[i][m-1] && board[i][m-1] == 'O')
            {
                 visited[i][m-1] = true;
                dfs(board, i, m-1, visited);
            }
            
        }

        for(int i = 0; i< n;i++)
        {
            for(int j =0; j<m;j++)
            {
                if(!visited[i][j])
                {
                    board[i][j] = 'X';
                }
            }
        }
        return ;


    }
};