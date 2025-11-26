class Solution {
    public boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj,int visited[])
    {
        if(visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;

        for(int neig: adj.get(node))
        {

            if (visited[neig] == 1) {
                // back edge to a node in the current recursion stack
                return true;
            }
            
            if(visited[neig] == 0)
            {
                
            if(detectCycle(neig, adj, visited))
            {
                return true;
            }  
            }
        }
        visited[node] = 2;
        return false;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
        }
        int visited[] = new int[numCourses];

        for(int i = 0;i<numCourses;i++)
        {
            if(visited[i] == 0)
            {
                
                if(detectCycle(i,adj,visited))
                {
                    return false;
                }
            }
        }
        return true;
    }
}