class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> st = new Stack<int[]>();
        int ans[] =new int[temperatures.length];
        
        for(int i = n - 1; i >= 0;i--)
        {
            while(!st.isEmpty() && st.peek()[0] <= temperatures[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                ans[i] = st.peek()[1] - i;
                
            }
            st.push(new int[]{temperatures[i],i});
            
        }

        return ans;

    }
}