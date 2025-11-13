class Solution {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int idx = 0;

        while(start < end)
        {

            if(start < idx) return false;
            start = Math.max(start, idx + nums[idx]);
            idx++;
        }
        return true;


    }
}