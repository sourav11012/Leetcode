class Solution {

    // boolean dfs(int curr, int[] visited, List<List<Integer>> adj)
    // {

    //     if(visited[curr] == 1) return true;
    //     if(visited[curr] == 2) return false;

    //     visited[curr] = 1;

    //     for(int neigh : adj.get(curr))
    //     {
            

           
    //             if(dfs(neigh, visited, adj)){
    //                 return true;
    //             }
            
    //     }
    //     visited[curr] =2;
    //     return false;

    // }



    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< numCourses; i++)
        {
           
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty())
        {
            int curr = q.poll();
            topo.add(curr);

           
            for(int neig : adj.get(curr))
            {
                indegree[neig]--;
                if(indegree[neig] == 0) {
                    q.offer(neig);
                    
                }
            }
        }

        return topo.size() == numCourses;
        




        // List<List<Integer>> adj =new ArrayList<>();
        // for(int i = 0;i <numCourses; i++)
        // {
        //     adj.add(new ArrayList<>());
        // }

        // for(int [] edge : prerequisites)
        // {
        //     adj.get(edge[1]).add(edge[0]);
        // }

        // int[] visited = new int[numCourses];
        // for(int i = 0 ;i < numCourses; i++)
        // {
        //     if(dfs(i,visited, adj)){
        //     return false;
        // }
        // }
        

        // return true;
    }
}