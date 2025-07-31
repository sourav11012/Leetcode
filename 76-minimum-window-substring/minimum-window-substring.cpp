class Solution {
public:
    string minWindow(string s, string t) {
        int startIdx = -1;
        unordered_map<char, int>map;
        int right = 0;
        int left = 0;
        int minLen = 1e9;

        for(char ch: t)
        {
            map[ch]++;
        }
        int count=t.length();
        while(right < s.length())
        {
            char curr = s[right];
            if(map[curr] >0)
            {
                count--;
            }
            map[curr]--;
            while(count == 0)
            {
                if(right - left + 1 < minLen)
                {
                    minLen = right - left + 1;
                    startIdx = left;
                }
                map[s[left]]++;
                if(map[s[left]]>0) count++;
                left++;
            }

            right++;

        }
        return startIdx == -1 ? "" : s.substr(startIdx,minLen);
    }
};