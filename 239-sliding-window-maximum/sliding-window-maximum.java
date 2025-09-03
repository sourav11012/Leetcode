class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();

        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = new int[nums.length - k + 1];

        
        for(int right = 0;right < nums.length; right++)
        {

            if(!dq.isEmpty() && dq.peekFirst() <= right - k)
            {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right])
            {
                dq.removeLast();
            }

            dq.addLast(right);

            if(right >=  k - 1)
            {
                arr[right - k + 1] = nums[dq.peekFirst()];
            }




        }

        return arr;




    }
}