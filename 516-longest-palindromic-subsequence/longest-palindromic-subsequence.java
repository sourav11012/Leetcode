class Solution {

    private int lcs(String s1, String s2, int idx1, int idx2,HashMap<String, Integer> map)

    {
        if(idx1 < 0 || idx2 < 0)
        {
            return 0;
        }
        String key = idx1+" "+idx2;
        if(map.containsKey(key)) return map.get(key);

        if(s1.charAt(idx1) == s2.charAt(idx2))
        {
            return 1 + lcs(s1, s2, idx1-1, idx2-1,map);
        }

        int max =  Math.max(lcs(s1, s2, idx1-1, idx2,map), lcs(s1, s2, idx1 , idx2-1,map));
        map.put(key, max);
        return max;
    }

    public int longestPalindromeSubseq(String s) {
        
        String reversed = new StringBuilder(s).reverse().toString();
        HashMap<String, Integer> map = new HashMap<>();
        return lcs(s, reversed,s.length()-1, s.length()-1, map);
    }
}