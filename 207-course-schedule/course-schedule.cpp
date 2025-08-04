class Solution {
public:

    bool dfs(int node,unordered_map<int, vector<int>> & adj,vector<int> & visited,set<int> &parent )
    {
        
        
        visited[node] = 1;
        parent.insert(node);

        for(auto neig : adj[node])
        {  
            if(parent.count(neig)) return false;
            
            if(!visited[neig])
            {
                if(!dfs(neig, adj, visited, parent))
                {
                    return false;
                }
            }
           
        }
         parent.erase(node);
        
        return true;
    }


    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>>adj;
        for(auto & pre : prerequisites)
        {
            adj[pre[0]].push_back(pre[1]);
        }

        vector<int> visited(numCourses,0);
        set<int> parent;
        bool result = false;
        for(int i = 0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(!dfs(i , adj, visited, parent)){
                    return false;
                }
            }
        }

        return true;
        
    }
};