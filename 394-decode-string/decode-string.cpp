class Solution {
public:
    string decodeString(string s) {
        stack<string> st;
        stack<int> countStack;
        string curr = "";
        int k = 0;
        for(char ch : s)
        {

            if(isdigit(ch))
            {
                k = k * 10 + (ch - '0');
            }else if(ch == '[')
            {
                st.push(curr);
                countStack.push(k);
                k = 0;
                curr= "";
            }else if(ch == ']')
            {
                string temp = curr;
                curr = st.top();
                st.pop();
                int repeat = countStack.top();
                countStack.pop();
                while(repeat)
                {
                    curr += temp;
                    repeat--;
                }

                
            }else{
                curr +=ch;
            }




        }
        return curr;
    }
};