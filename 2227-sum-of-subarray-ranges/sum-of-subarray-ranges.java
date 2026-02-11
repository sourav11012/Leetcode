class Solution {

    public int[] nse(int[]arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = n-1; i>=0;i--)
        {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
            {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        
        return result;
    }
    public int[] nge(int[]arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = n-1; i>=0;i--)
        {
            while(!st.isEmpty() && arr[i] >= arr[st.peek()])
            {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
         return result;
    }
    public int[] psoe(int[]arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n;i++)
        {
            while(!st.isEmpty() && arr[i] < arr[st.peek()])
            {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
         return result;
    }
    public int[] pgoe(int[]arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n;i++)
        {
            while(!st.isEmpty() && arr[i] > arr[st.peek()])
            {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
         return result;
    }

    public long subArrayRanges(int[] nums) {
        
        
        
        int[] prevSmall = psoe(nums);
        int[] nextSmall = nse(nums);
        int[] prevGreat = pgoe(nums);
        int[] nextGreat = nge(nums);

        long minSum = 0;
        long maxSum = 0;

        for(int i=0;i<nums.length;i++){

            long left = i - prevSmall[i];
            long right = nextSmall[i] - i;

            minSum += left * right * nums[i];

            left = i - prevGreat[i];
            right = nextGreat[i] - i;

            maxSum += left * right * nums[i];
        }

        return maxSum - minSum;
    }
}