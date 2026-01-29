class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0 ;
        int offset = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                count++;
            }else{
                
                count--;
                if(count < 0)
                {
                    offset++;
                    count=0;
                }
            }
        }

        return count + offset;
    }
}