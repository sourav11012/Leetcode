class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int maxA = 0;
        while(left < right)
        {

            int width = right - left;
            maxA = max((width * min(height[left], height[right])) , maxA);

            if(height[left] <= height[right])
            {
                left++;
            }else{
                right--;
            }

        }
        return maxA;
    }
};