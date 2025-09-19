class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int curr = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = curr + nums[left] + nums[right];

                if (currSum == 0) {
                    ans.add(List.of(curr, nums[left], nums[right]));

                    // Skip duplicates for left & right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (currSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}
