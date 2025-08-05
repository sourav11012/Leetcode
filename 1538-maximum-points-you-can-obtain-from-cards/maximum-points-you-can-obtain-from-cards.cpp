class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
       
        int totalSum = 0;
        for(int num: cardPoints)
        {
            totalSum += num;
        }
        
        int windowSum = 0;
        int minWindowSize = cardPoints.size() - k;
        for(int i = 0;i< minWindowSize ;i++)
        {
            windowSum += cardPoints[i];
        }   
        cout<<windowSum<<endl;
        int minSum = windowSum;

        int right = minWindowSize;
        int left = 0;

        while(right < cardPoints.size())
        {
            windowSum += cardPoints[right];
            windowSum  -= cardPoints[left];
            cout<<"window sum"<<windowSum<<" at "<<right<<endl;
            minSum = std::min(minSum , windowSum);
            cout<<"min sum"<<minSum<<" at "<<right<<endl;
            right++;
            left++;
        }
        return (totalSum == minSum) ? minSum : totalSum - minSum;
        
    }
};