class Solution {

    void fn(int start, int end, String s, Set<String> wordSet, List<String> curr, List<String> ds) {
        if (end == s.length()) {
            if (start == end) {
                ds.add(String.join(" ", curr));
            }
            return;
        }

        String sub = s.substring(start, end + 1);
        if (wordSet.contains(sub)) {
            curr.add(sub);
            fn(end + 1, end + 1, s, wordSet, curr, ds);
            curr.remove(curr.size() - 1);
        }

        if (end < s.length()) {
            fn(start, end + 1, s, wordSet, curr, ds);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> curr = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        fn(0, 0, s, wordSet, curr, ds);
        return ds;
    }
}
