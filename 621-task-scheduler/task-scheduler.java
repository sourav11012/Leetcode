class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        record Pair(char task, int time ){};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a ,  b)-> b.time() - a.time());
        int[] freq = new int[26];
        for(char ch : tasks)
        {
            freq[ch - 'A']++;
        }

        for(int i = 0;i<26;i++)
        {
            if(freq[i] > 0) pq.add(new Pair((char)(i + 'A'), freq[i]));
        }
        

        int time = 0;
        
        while(!pq.isEmpty())
        {   
            List<Pair> list = new ArrayList<>();
            int cycle = 0;
            while(cycle <= n  && !pq.isEmpty())
            {
                
                Pair curr = pq.remove();
                if(curr.time() - 1 > 0)
                {

                    list.add(new Pair(curr.task(), curr.time() - 1));
                }
                time++;
                cycle++;
                
            }
         
            for(Pair p : list)
            {
                pq.offer(p);
            }

            if(!pq.isEmpty())
            {
                time += (n + 1 - cycle);
            }

        }
        return time;
    }
}