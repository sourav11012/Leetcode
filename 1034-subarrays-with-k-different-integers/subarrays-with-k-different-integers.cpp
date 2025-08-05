class Solution {
public:

    int atMaxK(int k,vector<int>& nums )
    {
int right = 0;
        int left = 0;
        int n = nums.size();
        unordered_map<int, int> map;
        int count = 0;
        while(right < n)
        {
            map[nums[right]]++;

            while(map.size() > k)
            {
                map[nums[left]]--;
                if(map[nums[left]]==0)
                {
                    map.erase(nums[left]);
                }
                left++;
            }
            count += right - left +1;
            right++;
        }

        return count;
    }
    int subarraysWithKDistinct(vector<int>& nums, int k) {



        return atMaxK(k, nums) - atMaxK(k -1, nums);
        
    }
};