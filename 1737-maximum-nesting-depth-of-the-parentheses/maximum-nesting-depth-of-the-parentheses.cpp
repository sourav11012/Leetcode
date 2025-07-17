class Solution {
public:
    int maxDepth(string s) {
        int count = 0;
        int maxCount = -100;
        for(char ch : s)
        {
            if(ch == '(')
            {
                count++;
            }else if(ch == ')'){
                count--;
            }

            maxCount = max(maxCount, count);
        }
        return maxCount;
    }
};