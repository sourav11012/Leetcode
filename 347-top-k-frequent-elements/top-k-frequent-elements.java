class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        record Pair(int first, int second){};

        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> a.second() - b.second() );

        for(int n : nums)
        {
            map.put(n , map.getOrDefault(n,0) + 1);
        }
        for(Integer key : map.keySet())
        {
            pq.offer(new Pair(key, map.get(key)));

            while(pq.size() > k)
            {
                pq.remove();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty())
        {
            ans[i] = pq.remove().first();
            i++;
        }

        return ans;
    }
}