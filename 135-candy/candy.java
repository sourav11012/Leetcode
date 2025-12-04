class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int sum =1;
        int peak = 1;
        int down = 1;
        while(i < n)
        {
            if(ratings[i] == ratings[i-1])
            {
             sum+=1;
            
             i++;
              continue;
            } 
            peak = 1;

            while(i < n && ratings[i] > ratings[i-1])
            {
                peak = peak + 1;
                sum = sum + peak;
                i++;
            }
            down = 1;
            while(i < n && ratings[i] < ratings[i-1])
            {
                
                sum = sum + down;
                down = down + 1;
                i++;
            }
            if(down > peak)
            {
                sum = sum + (down - peak);
            }
            


        }
        return sum;
    }
}