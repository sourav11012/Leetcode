class Solution {
    public String countAndSay(int n) {
        String result = "1";
        

        for(int i = 1 ;i < n ;i++)
        {
            int count = 1;
            StringBuilder sb = new StringBuilder();

            for(int j = 1 ; j < result.length(); j++ )
            {
                if(result.charAt(j) == result.charAt(j - 1))
                {
                    count++;
                }else{
                    sb.append(count).append(result.charAt(j-1));
                    count = 1;
                }
            }

            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }

        return result;

    }
}

//1 -> 11 -> 21 -> 1211 -> 111221 -> 312111 -> 13111231