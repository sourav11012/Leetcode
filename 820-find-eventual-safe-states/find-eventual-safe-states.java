class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i =0 ;i<graph.length;i++)
        {
            adj.add(new ArrayList<>());     
        }

        for(int i =0 ;i<graph.length;i++)
        {
            for(int neig : graph[i])
            {
                adj.get(neig).add(i);
            }     
        }

        int[] indegree = new int[n];

        for(int i = 0; i< n ; i++)
        {
            for(int itr : adj.get(i))
            {
                indegree[itr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < indegree.length; i++)
        {
            if(indegree[i]== 0)
            q.offer(i);
        }
        List<Integer> topoSort = new ArrayList<>();

        while(!q.isEmpty())
        {
            int curr = q.poll();

            if(indegree[curr] == 0) {
                topoSort.add(curr);
            }

            for(int neigh : adj.get(curr))
            {
                indegree[neigh]--;
                if(indegree[neigh] == 0)
                {
                    q.offer(neigh);
                }
            }
        }
        // if(topoSort.size() != numCourses) return new int[]{};

        // int[] out = new int[topoSort.size()];

        // for(int i = 0;i<topoSort.size();i++)
        // {
        //     out[i] = topoSort.get(i);
        // }
        Collections.sort(topoSort);
        return topoSort;
    }
}