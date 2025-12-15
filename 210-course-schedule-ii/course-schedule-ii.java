class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i< numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i< numCourses ; i++)
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
        if(topoSort.size() != numCourses) return new int[]{};

        int[] out = new int[topoSort.size()];

        for(int i = 0;i<topoSort.size();i++)
        {
            out[i] = topoSort.get(i);
        }
        return out;

       
    }
}