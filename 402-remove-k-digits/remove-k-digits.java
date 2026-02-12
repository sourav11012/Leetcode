class Solution {
    public String removeKdigits(String num, int k) {

        Deque<Integer> st = new ArrayDeque<>();

        for(char ch : num.toCharArray()) {

            int digit = ch - '0';

            while(!st.isEmpty() && k > 0 && st.peekLast() > digit){
                st.pollLast();
                k--;
            }

            st.addLast(digit);
        }

        // remove remaining digits
        while(k > 0){
            st.pollLast();
            k--;
        }

        // build result
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        while(!st.isEmpty()){
            int d = st.pollFirst();

            if(leadingZero && d == 0)
                continue;

            leadingZero = false;
            sb.append(d);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
