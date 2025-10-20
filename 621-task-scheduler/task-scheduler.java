class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int[] freq = new int[26];
        for (char ch : tasks) freq[ch - 'A']++;

        int maxFreq = 0;
        for (int f : freq) maxFreq = Math.max(maxFreq, f);

        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) countMax++;
        }

        // Formula-based solution
        int partCount = maxFreq - 1;
        int emptySlots = partCount * (n + 1) + countMax;

        return Math.max(emptySlots, tasks.length);
    }
}
