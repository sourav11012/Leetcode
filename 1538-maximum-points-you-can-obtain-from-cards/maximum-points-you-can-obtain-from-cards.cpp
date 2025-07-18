class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int currentSum = 0;
        for(int i = 0;i<k;i++)
        {   
            currentSum += cardPoints[i];

        }
      
        int maxSum = currentSum;
        int left = k - 1;
        int right = cardPoints.size() - 1;
        while(left  >= 0)
        {
            currentSum -= cardPoints[left--];
            currentSum += cardPoints[right--];
            maxSum = max(maxSum, currentSum);
        }

        return maxSum;
    }
};