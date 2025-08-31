class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> map;
        map[0] = 1;
        int maxCount = 0;

        int preSum =0;

        for(int num : nums)
        {
             preSum += num;
            
            if(map.count(preSum - k))
            {
                maxCount += map[preSum - k];
            }
             map[preSum] += 1;
           
            
        }

        return maxCount;

    }
};