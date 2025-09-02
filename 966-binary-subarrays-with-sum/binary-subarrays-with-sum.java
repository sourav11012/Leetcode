class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int preSum = 0;
        int count = 0;

        for(int right = 0;right <nums.length;right++ )
        {

            preSum += nums[right];

            if(map.containsKey(preSum - goal))
            {
                count += map.get(preSum - goal);
            }

            map.put(preSum , map.getOrDefault(preSum, 0) + 1);



        }
        return count;
    }
}