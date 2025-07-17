class Solution {
public:
    int romanToInt(string s) {
    unordered_map<string, int> romanMap = {
    {"I", 1}, {"V", 5}, {"X", 10}, {"L", 50},
    {"C", 100}, {"D", 500}, {"M", 1000},
    {"IV", 4}, {"IX", 9}, {"XL", 40}, {"XC", 90},
    {"CD", 400}, {"CM", 900}
};
        int i =0;
        int ans = 0;
        while(i < s.length())
        {
            string first = s.substr(i,2);
            if(romanMap.count(first))
            {
                ans = ans + romanMap[first];
                i += 2;
            }else{
                string ch(1,s[i]);
                ans =ans + romanMap[ch];
                i++;
            }
        }

        return ans;
        
    }
};