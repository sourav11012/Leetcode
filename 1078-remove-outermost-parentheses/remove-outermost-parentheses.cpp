class Solution {
public:
    string removeOuterParentheses(string s) {
         std::string temp;   // acts like Java's StringBuilder

        int right = 0;
        int left  = 0;
        int count = 0;

        while (left < static_cast<int>(s.length())) {
            if (s[left] == '(')
                ++count;
            else if (s[left] == ')')
                --count;

            if (count == 0) {
                // copy everything between the outermost '(' ... ')'
                temp.append(s.substr(right + 1, left - right - 1));
                right = left + 1;    // start of next primitive
            }
            ++left;
        }
        return temp;
    }
};