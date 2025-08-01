class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n2 < n1) return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = n1;
        int n = n1 + n2;
        int left = (n1 + n2 +1) >>1;

        while(low <= high)
        {
            int mid1 = (low + high) >>1;
            int mid2 = left - mid1;

            int leftMax1 = INT_MIN, leftMax2 = INT_MIN;
            int rightMin1 = INT_MAX, rightMin2 = INT_MAX;
            if(mid1 < n1) rightMin1 = nums1[mid1];
            if(mid2 < n2) rightMin2 = nums2[mid2];
            if(mid1 - 1 >=0 ) leftMax1 = nums1[mid1 -1];
            if(mid2 - 1 >= 0) leftMax2 = nums2[mid2 - 1];

            if(leftMax1 <= rightMin2 && leftMax2 <= rightMin1)
            {
                if( (n1 + n2) & 1 == 1 ) return max(leftMax1 ,leftMax2);
                else return (double)(max(leftMax1,leftMax2) + min(rightMin1, rightMin2)) / 2.0;
            }else if(leftMax1 > rightMin2){ high = mid1 -1;
                
            }else{
                low = mid1 + 1;
            }
        }
        return -1.0;
    }
};