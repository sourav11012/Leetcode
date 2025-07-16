class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
    
        string maxPrefix;
        int min = 1e9;

        for(string temp : strs)
        {
            if(temp.length() < min)
            {
                min = temp.length();
                maxPrefix = temp; 
            }
        }
        string ans = "";
        for(int i = 0 ;i< min ;i++)
        {
            for(string str : strs)
            {
                if(str[i] != maxPrefix[i]) return ans;
                
            }
            ans.append(1,maxPrefix[i]);
        }

        return ans;
    }
};