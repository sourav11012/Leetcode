class Solution {
    public boolean lemonadeChange(int[] bills) {
        
    
        if(bills[0] > 5) return false;

        int[] freq = new int[3];
        freq[0] = 1;
        int totalCash = 0;
        for(int i =1 ; i<bills.length; i++)
        {

        if(bills[i] == 5) 
        {
            freq[0]++;
        }else if(bills[i] == 10)
        {
            freq[1]++;
            if(freq[0] == 0) return false;
            freq[0]--;
        }else if(bills[i] == 20)
        {
            freq[2]++;
            
            if(freq[1] == 0 && freq[0] < 3) return false;

            if(freq[1] > 0) {
                freq[1]--;
                if(freq[0] == 0) return false;
                freq[0]--;
                continue;
            }

            if(freq[0] >= 3)
            {
                freq[0] -=3;
                continue;
            }
            
        }
            
       
        }
         return true;
    }
}