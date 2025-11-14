class Solution {

    void dfs(int curr, List<List<Integer>> adj,int visited[] )
    {
        if(visited[curr] == 1) return;
        visited[curr] = 1;
        
        List<Integer> neighs = adj.get(curr);

        for(int neigh : neighs)
        {
            if(visited[neigh] != 1)
            {
                dfs(neigh,adj,visited);
            }
        }
        return;
    }


    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int m = isConnected[0].length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;i <n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(isConnected[i][j] == 1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }

            }
        }

        int visited[] = new int[n];
    
        int count = 0;
       for(int i = 0;i<n;i++)
       {
        if(visited[i] == 0)
        {
            dfs(i,adj,visited);
            count += 1;
        }

      

        
       }
         return count;
        
        


    }
}