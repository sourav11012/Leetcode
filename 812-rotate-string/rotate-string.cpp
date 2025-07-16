class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.length() != goal.length())
        {
            return false;
        }
        string concate = s.append(s);

        for(int i = 0;i <= concate.length() - goal.length(); i++)
        {
            if(concate.substr(i,goal.length()) == goal) return true;
        }
        return false;
    }
};