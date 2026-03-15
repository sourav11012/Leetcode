class Solution {
public:
    int trap(vector<int>& height) {
    vector<int> leftMax;
    vector<int> rightMax;
    
    int lMax = 0;
    for(int i =0;i < height.size() ;i++)
    {
        if(height[lMax] <= height[i])
        {
            leftMax.push_back(i);
            lMax = i;
        }else{
            leftMax.push_back(lMax);
        }
    }
    for(int i : leftMax)
    {
        cout<<" "<< i ;
    }
    cout<<endl;
    int rMax = height.size() - 1;
    for(int i =height.size() - 1;i >= 0 ;i--)
    {
        if(height[rMax] <= height[i])
        {
            rightMax.push_back(i);
            rMax = i;
        }else{
            rightMax.push_back(rMax);
        }
    }
    reverse(rightMax.begin(), rightMax.end());
    for(int i : rightMax)
    {
        cout<<" "<< i ;
    }
    int totalWater = 0;
    for(int i = 0 ; i <height.size() -1 ;i++)
    {
        totalWater +=  min(height[leftMax[i]], height[rightMax[i]]) - height[i];
    }
    
    return totalWater;
    
    }
};