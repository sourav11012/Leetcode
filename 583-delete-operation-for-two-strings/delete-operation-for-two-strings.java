class Solution {
    private int lcs(String s, String reversed)
    {
        int prev[] = new int[s.length() + 1];
        int curr[] = new int[s.length() + 1];

        for(int idx1 = 1 ; idx1 <= s.length(); idx1++)
        {
            for(int idx2 = 1 ; idx2 <= reversed.length() ; idx2++)
            {
                if(s.charAt(idx1 - 1) == reversed.charAt(idx2 - 1))
                {
                    curr[idx2] = 1 + prev[idx2-1];
                }
                else {
                    curr[idx2] = Math.max(prev[idx2], curr[idx2-1]);
                }
            }

            // swap arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;

            Arrays.fill(curr, 0);
        }

        return prev[reversed.length()];
    }
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int lcs= 0;
        if(l1 < l2)
        {
        lcs = lcs( word2 , word1);
        }else{
           lcs =  lcs( word1 , word2);
        }
        
        System.out.println("lcs " + lcs);
        return (word1.length() - lcs) +( word2.length() - lcs);
    }
}