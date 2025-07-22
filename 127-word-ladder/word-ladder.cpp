class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        queue<pair<string,int>> q;
        q.push({beginWord, 1});
        unordered_set<string> st(wordList.begin(), wordList.end());

        st.erase(beginWord);


        while(!q.empty())
        {


            string currWord = q.front().first;
            int step = q.front().second;
            q.pop();

            if(currWord == endWord) return step;

            for(int i = 0;i< currWord.length();i++)
            {
                char og = currWord[i];

                for(char ch='a' ; ch <= 'z';ch++)
                {
                    currWord[i] = ch;
                    if(st.find(currWord) != st.end()) {
                        st.erase(currWord);
                        q.push({currWord, step +1});
                        
                    }
                    
                }
                currWord[i] = og;
            }
            
        }
        return 0;
    }
};