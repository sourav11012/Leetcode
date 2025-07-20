class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> map;
        map[0] = 1;
        int currSum = 0;
        int count = 0;
       
        for(int num : nums)
        {
            currSum += num;

            if(map.find(currSum - k) != map.end())
            {
                count += map[currSum - k];
            }

            map[currSum]++;
        }

        return count;

    }
};