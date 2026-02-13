class Solution {
    public int leastInterval(char[] tasks, int n) {
         Map<Character, Integer> map = new HashMap<>();

        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // max heap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b) -> b - a);

        pq.addAll(map.values());
        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> temp =new ArrayList<>();
            int cycle = n+1;

            while(cycle > 0 && !pq.isEmpty())
            {
                int freq = pq.poll();
                freq--;

                if(freq> 0)
                {
                    temp.add(freq);
                }
                time++;
                cycle--;
            }

            for(int f:temp)
            {
                pq.offer(f);
            }

            if(pq.isEmpty())
            {
                break;
            }

            time +=cycle;


        }
        return time;

    }
}