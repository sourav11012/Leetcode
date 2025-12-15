class Solution {
    //0 -> not visited
    // 1 -> cycle detected
    // 2 -> completely visited

    // public boolean findCycle(int curr,List<List<Integer>> adj, int[]visited )
    // {
        
    //     visited[curr] = 1;
    //     for(int neig : adj.get(curr))
    //     {
    //         if(visited[neig] == 1) return false;  // cycle detected

    //         if(visited[neig] == 0)
    //         {
    //             if (!findCycle(neig, adj, visited)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     visited[curr] = 2;
    //     return true;

    // }

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
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i< indegree.length;i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        ArrayList<Integer> topo =  new ArrayList<>();

        while(!q.isEmpty())
        {
            int currNode = q.poll();
            if(indegree[currNode] == 0 ) {
                topo.add(currNode);
            }
            
            for(int neigh : adj.get(currNode))
            {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }


        return topo.size() == numCourses;
    }
}