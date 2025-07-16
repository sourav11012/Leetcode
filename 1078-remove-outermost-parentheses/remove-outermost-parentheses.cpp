class Solution {
public:
    string removeOuterParentheses(string s) {
        string temp; 
        int right = 0;
        int left = 0;
        int count = 0;

        while(left < s.length())
        {


            if(s[left] == '(') count++;
            else if(s[left] == ')') count--;

            if(count ==0)
            {
                temp.append(s.substr(right + 1, left - right - 1));
                right = left + 1;
            }
            left++;
        }
        return temp;
    }
};