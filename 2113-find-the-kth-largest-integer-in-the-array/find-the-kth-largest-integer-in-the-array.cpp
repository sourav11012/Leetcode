class Solution {
public:
    string kthLargestNumber(vector<string>& nums, int k) {

        auto cmp = [](const string& a, const string& b){
            if(a.size() == b.size())
            {
                return a > b;
            }
            return a.size() > b.size();
        };


        priority_queue<string,vector<string>,decltype(cmp)> pq;

        for(auto &num :nums)
        {
            pq.push(num);

            while(pq.size() > k)
            {
                pq.pop();
            }
        }
        return pq.top();


    }
};