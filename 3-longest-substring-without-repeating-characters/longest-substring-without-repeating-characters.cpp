class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> map;
        int left =0;
        int right =0;
        int maxLen = 0;
        while(right < s.length())
        {
            if(map.count(s[right]) && map[s[right]] >= left)
            {
                left = map[s[right]] + 1;
                
            }
                map[s[right]] = right;
            
            
            maxLen = max(maxLen,  right - left + 1); 
           
            right++;


        }

        return maxLen;
    }
};