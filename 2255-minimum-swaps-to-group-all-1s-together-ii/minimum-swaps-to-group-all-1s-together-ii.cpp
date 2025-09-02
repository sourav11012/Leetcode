class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        
        vector<int> temp(nums.begin(), nums.end());
        
        int countOne = 0;
        for(int num : nums)
        {
            if(num == 1) countOne++;
            temp.push_back(num);
        }
        if(nums.size() == countOne) return 0;

        
        int left = 0;

        int zeroCount = 0;
        for(int i = 0;i<countOne;i++)
        {
            if(temp[i] == 0) zeroCount++;
        }
        int right = countOne - 1;

        int minZero = zeroCount;

        while(right < temp.size() - 1)
        {
            
            if(temp[++right] == 0)
            {
                zeroCount++;
            }
            if(temp[left++] == 0)
            {
                zeroCount--;
            }
            minZero = min(minZero , zeroCount);

        }

        
        return minZero;

    }
};