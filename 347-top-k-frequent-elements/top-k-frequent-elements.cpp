class Solution {
public:

     
    vector<int> topKFrequent(vector<int>& nums, int k) {




        auto cmp = [](const pair<int,int> & a, const pair<int,int> & b){
            return a.second > b.second;
        };

        unordered_map<int,int> freq;
        for(int num :nums)
        {
            freq[num]++;
        }
        priority_queue<pair<int,int> , vector<pair<int,int>>, decltype(cmp)> pq(cmp);

        for(auto& [num, fr] : freq)
        {
            
            pq.push({num, fr});
            if(pq.size() > k){
                pq.pop();
            }
        }
        // vector<int> ans(pq.begin(),pq.end());
        vector<int> ans;
        while(!pq.empty())
        {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        return ans;
    }
};