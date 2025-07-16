class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length() != t.length()) return false;

        unordered_map<char,char> maps;
        unordered_map<char,char> mapt;

        for(int i = 0; i< s.length();i++)
        {
            char cs = s[i];
            char ct =t[i];
            
            if(maps.count(cs))
            {
                if(maps[cs] != ct) return false;
               
            }
             else{
                    maps[cs] = ct;
                }

            if(mapt.count(ct))
            {
                if(mapt[ct] != cs) return false;
            }else{
                mapt[ct] = cs;
            }
        }

        return true;

      

    }
};