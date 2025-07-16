class Solution {
    public String removeOuterParentheses(String s) {
        
        StringBuilder temp = new StringBuilder();

        int right = 0;
        int left = 0;
        int count = 0;
        while(left < s.length())
        {
            if(s.charAt(left ) == '(') count++;
            else if(s.charAt(left) == ')')count--;

            if(count == 0)
            {
                temp.append(s.substring(right + 1, left));
                right = left + 1;

            }
            left++;
        }

        return temp.toString();
    }
}