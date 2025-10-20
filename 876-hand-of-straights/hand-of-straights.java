import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (count > 0) {
                // Try to form group starting from key
                for (int i = 0; i < groupSize; i++) {
                    int curr = key + i;
                    if (!freq.containsKey(curr) || freq.get(curr) < count)
                        return false; // cannot form a valid straight group
                    freq.put(curr, freq.get(curr) - count);
                }
            }
        }
        return true;
    }
}
