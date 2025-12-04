class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftCandies = new int[n];
        int[] rightCandies = new int[n];

        Arrays.fill(leftCandies, 1);
        Arrays.fill(rightCandies, 1);

        // LEFT → RIGHT
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1;
            }
        }

        // RIGHT → LEFT
        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                rightCandies[j] = rightCandies[j + 1] + 1;
            }
        }

        // FINAL SUM
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(leftCandies[i], rightCandies[i]);
        }

        return sum;
    }
}
