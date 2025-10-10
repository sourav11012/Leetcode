class Solution {
public:
    int countSubstrings(string s) {
        

        int n = s.size();
        int count = 0;

        auto compute = [&](int left , int right){
            int cnt= 0;
            while(left >= 0 && right < n && s[left] == s[right])
            {
            cnt++;
            left--;
            right++;
            }
            return cnt;
        };

        for(int i = 0;i<n;i++)
        {
            count += compute(i, i);
            count += compute(i , i+1);
        }
        return count;


    }
};