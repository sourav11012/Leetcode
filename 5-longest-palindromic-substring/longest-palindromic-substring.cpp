class Solution {
public:
    string expand(const string &s, int left, int right) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        return s.substr(left + 1, right - left - 1);
    }

    string longestPalindrome(string s) {
        string ans;
        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Odd length palindrome
            string temp1 = expand(s, i, i);
            if (temp1.length() > maxLength) {
                maxLength = temp1.length();
                ans = temp1;
            }

            // Even length palindrome
            string temp2 = expand(s, i, i + 1);
            if (temp2.length() > maxLength) {
                maxLength = temp2.length();
                ans = temp2;
            }
        }
        return ans;
    }
};
