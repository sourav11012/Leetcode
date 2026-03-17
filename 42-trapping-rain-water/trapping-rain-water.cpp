class Solution {
public:
    int trap(vector<int>& height) {
    int n = height.size();
    int left = 0;
    int right = n-1;

    int leftMax = height[0];
    int rightMax = height[n-1];
    // vector<int> result(n);
    int water = 0;

    while(left < right)
    {
        if(height[left] <= height[right])
        {
            if(leftMax > height[left])
            {
                water += leftMax - height[left];
            }else{
                leftMax = height[left];
                
            }
            left++;
            
        }else{
            if(rightMax > height[right])
            {
                water += rightMax - height[right];
            }else{
                rightMax = height[right];
            }
            right--;
        }
    }
    return water;

    }
};