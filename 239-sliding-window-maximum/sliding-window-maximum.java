class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<Integer>();

        List<Integer> list = new ArrayList<>();
        for(int i =0 ;i<nums.length;i++)
        {

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();

            }
            dq.addLast(i);

            while(dq.size() > k || dq.peekFirst() < (i - k) + 1)
            {
                dq.pollFirst();
            }




            if(!dq.isEmpty() && i >= k - 1 )
            {
                list.add(nums[dq.peekFirst()]);
            }


        }
        int[] arr= new int[list.size()];

        int i =0;
        for(int t : list)
        {
            arr[i++] = t;
        }
        return arr;
    }
}