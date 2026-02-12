class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        if(groupSize == 1) return true;

        TreeMap<Integer, Integer> map = new TreeMap<>();


        for(int i : hand)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        while(!map.isEmpty())
        {
            
            int start = map.firstKey();

            int count = map.get(start);

            for(int i =0;i<groupSize; i++)
            {
                int num = start + i;

                if(!map.containsKey(num) || map.get(num) < count) return false;

                if(map.get(num) == count) map.remove(num);
                else map.put(num, map.get(num) - count);
                
            }

        }   
        return map.isEmpty();
        
        // [1,2,2,3,3,4,6,7,8]
    }
}