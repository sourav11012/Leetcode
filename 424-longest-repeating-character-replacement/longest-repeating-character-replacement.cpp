class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> freq(26,0);
        int right = 0;
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        while(right < s.length())
        {
            freq[s[right] - 'A']++;
            maxFreq = max(maxFreq, freq[s[right] - 'A']);
            int window = right - left + 1;
            int changesNeeded = window - maxFreq;
            if(changesNeeded <= k)
            {
                maxLen = max(window , maxLen);
            }else{
                freq[s[left] - 'A']--;
                left++;
            }
            right++;
        }

        return maxLen;

    }
};