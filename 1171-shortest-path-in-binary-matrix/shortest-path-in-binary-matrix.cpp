class Solution {
public:
    struct Node{
        int first;
        int second;
        int distance;

        Node( int first, int second,int distance): first(first) , second(second), distance(distance){};

    };




    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        queue<Node> q;
        vector<vector<int>> visited(n, vector<int>(m,0));

        if(grid[0][0] == 1 || grid[n - 1][m-1] == 1) return -1;
        Node node(0,0,1);
        visited[0][0] = 1;
        q.push(node);

        while(!q.empty())
        {
            Node curr = q.front();
            q.pop();

            if(curr.first == n- 1 && curr.second == m - 1 ) return curr.distance;

            int dirs [8][2]={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

            for(auto dir : dirs)
            {
                int newRow = curr.first + dir[0];
                int newCol = curr.second + dir[1];

                if(newRow < n && newRow >=0 && newCol < m && newCol >=0 && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 0)
                {
                    visited[newRow][newCol] = 1;
                    Node temp(newRow, newCol , curr.distance + 1 );
                    q.push(temp);
                }
            }

            





        }
        return -1;
    }
};