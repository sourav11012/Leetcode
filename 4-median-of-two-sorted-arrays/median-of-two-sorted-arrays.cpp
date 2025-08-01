class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> merge(nums1.size() + nums2.size());

        int first = 0;
        int second = 0;
        int ptr = 0;

        while (first < nums1.size() && second < nums2.size()) {
            if (nums1[first] <= nums2[second]) {
                merge[ptr] = nums1[first];
                ptr++;
                first++;
            } else {
                merge[ptr] = nums2[second];
                ptr++;
                second++;
            }
        }

        while (first < nums1.size()) {
            merge[ptr] = nums1[first];
            ptr++;
            first++;
        }

        while (second < nums2.size()) {
            merge[ptr] = nums2[second];
            ptr++;
            second++;
        }

        int n = merge.size();
        if (n % 2 == 1) {
            return merge[n / 2];
        } else {
            int fidx = n / 2;
            int sidx = fidx - 1;
            return (merge[fidx] + merge[sidx]) / 2.0;
        }

        return -1; // unreachable, but syntactically valid
    }
};
