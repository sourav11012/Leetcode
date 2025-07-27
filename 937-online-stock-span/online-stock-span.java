class StockSpanner {
    Stack<int[]> st ;
    public StockSpanner() {
        st = new Stack<int[]>();
    }
    
    public int next(int price) {
        // int[] currPrice = new int[]{price,1};
        int span = 0;
        while(!st.isEmpty() && st.peek()[0] <= price)
        {
            span += st.pop()[1];
        }
        st.push(new int[]{price, span + 1});
        return st.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */