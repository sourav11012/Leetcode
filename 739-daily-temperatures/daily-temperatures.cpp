class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {

        int n = temperatures.size();
        vector<int> output(n,0);

        stack<int> st;

        for(int i = n-1 ; i>= 0;i--)
        {
            
            while(!st.empty() && temperatures[st.top()] <= temperatures[i])
            {
                    st.pop();
            }

            if(st.empty())
            {
                output[i] = 0;
                st.push(i);
            } 
            
            if(temperatures[st.top()] > temperatures[i])
            {
                output[i] = st.top() - i;
                
            }
            st.push(i);

            
                
            
        }

       

        return output;
    }
};