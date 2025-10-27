class Solution {
    public String reorganizeString(String s) {
        record pair(char ch , int count){};
       PriorityQueue<pair> pq= new PriorityQueue<pair>((a,b) -> b.count() - a.count());

       int[] freq = new int[26];
       for(char ch : s.toCharArray())
       {
            freq[ch - 'a']++;
       }

       for(int i = 0;i<26;i++)
       {
        if(freq[i] > 0 ) {
            pq.offer(new pair( (char) (i + 'a')  , freq[i]));
        }
       }


       StringBuilder sb = new StringBuilder();

       while(!pq.isEmpty() && pq.size() > 1)
       {
        pair first = pq.poll();
        pair second = pq.poll();
        sb.append(first.ch());
        sb.append(second.ch());
        if(first.count() - 1 > 0)
        {
            pq.offer(new pair(first.ch(), first.count() - 1));
        }
        if(second.count() - 1 > 0)
        {
            pq.offer(new pair(second.ch(), second.count() - 1));
        }
        
  
       }

       if(pq.size() == 1 && pq.peek().count() == 1)
       {
        sb.append(pq.poll().ch());
        return sb.toString();
       }
       if(pq.size() == 1 && pq.peek().count() >= 1)
       {
        return "";
       }

       return sb.toString();
    }
}