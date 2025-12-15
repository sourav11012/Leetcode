class Solution {
    //0 -> not visited
    // 1 -> cycle detected
    // 2 -> completely visited

    public boolean findCycle(int curr,List<List<Integer>> adj, int[]visited )
    {
        if(visited[curr] == 1) return false; // cycle detected
        
        visited[curr] = 1;
        for(int neig : adj.get(curr))
        {
            if(visited[neig] == 1) return false;

            if(visited[neig] == 0)
            {
                if (!findCycle(neig, adj, visited)) {
                    return false;
                }
            }
        }
        visited[curr] = 2;
        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!findCycle(i, adj, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}