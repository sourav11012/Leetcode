class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<n;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i =n - 1;i>=0;i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
            {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightMin[i] - leftMin[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
}