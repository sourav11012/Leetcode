class Solution {
public:
    int numberOfSubstrings(string s) {
        vector<int> arr(3,0);

      
        int right =0;
        int left =0;
        int count =0;
        while(right<s.length())
        {
            
            arr[s[right] - 'a']++;
            while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0)
            {
                count += s.size() - right;
                arr[s[left] - 'a']--;
                left++;
            }
            right++;
        }
        return count;

    }
};