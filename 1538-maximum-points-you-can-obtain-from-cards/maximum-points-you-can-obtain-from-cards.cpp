class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        int totalSum = accumulate(cardPoints.begin(), cardPoints.end(), 0);

        // If taking all cards
        if (k == n) return totalSum;

        int minWindowSize = n - k;
        int windowSum = 0;

        // Initialize window sum with the first (n - k) elements
        for (int i = 0; i < minWindowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;
        
        // Slide the window across the array
        for (int right = minWindowSize, left = 0; right < n; right++, left++) {
            windowSum += cardPoints[right] - cardPoints[left];
            minSum = min(minSum, windowSum);
        }

        return totalSum - minSum;
    }
};
