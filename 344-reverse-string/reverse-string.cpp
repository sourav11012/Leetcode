class Solution {
public:
    void reverseString(vector<char>& s) {
        int right = s.size()-1;
        int left= 0;

        while(right > left)
        {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            right--;
            left++;
        }

       return;

    }
};