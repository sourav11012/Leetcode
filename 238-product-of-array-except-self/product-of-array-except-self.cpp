class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> preMul(n);
        vector<int> postMul(n);
        
        preMul[0] = 1;
        postMul[n - 1] = 1;
        for(int i = 1;i<n; i++)
        {
            preMul[i] = preMul[i - 1] * nums[i - 1];
        }
        for(int j = n-2; j >= 0; j--)
        {
            postMul[j] = postMul[j + 1] * nums[j + 1];
        }

        vector<int> ans(n);
        for(int i = 0 ;i<n;i++)
        {
            
                ans[i] = (preMul[i] ) * (postMul[i] );
           
            
        }


           
        return ans;
    }
};