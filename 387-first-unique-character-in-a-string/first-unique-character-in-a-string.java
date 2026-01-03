class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i =0;i<n;i++)
        {
            char ch = s.charAt(i);
           
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
        }
        int lowest = -1;
        
        for(int i = 0; i<s.length();i++)
        {
            if(map.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }
        return lowest;
    }
}