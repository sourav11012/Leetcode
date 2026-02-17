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

        return prev[s.length()];
    }
    public int minInsertions(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s, reversed);
    }
}