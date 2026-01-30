class Solution {

    public boolean check(String a, String b) {
        int n = b.length();

        for (int i = 0; i + n <= a.length(); i++) {
            int p1 = i;
            int p2 = 0;

            while (p1 < a.length() && p2 < n &&
                   a.charAt(p1) == b.charAt(p2)) {
                p1++;
                p2++;
            }

            if (p2 == n) {
                return true;
            }
        }
        return false;
    }

    public int repeatedStringMatch(String a, String b) {
        if (b.equals("")) return 0;

        String repeated = a;
        int count = 1;

        // repeat until length >= b
        while (repeated.length() < b.length()) {
            repeated += a;
            count++;
        }

        if (check(repeated, b)) return count;

        // one extra repetition for overlap case
        repeated += a;
        count++;

        if (check(repeated, b)) return count;

        return -1;
    }
}
