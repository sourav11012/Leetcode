class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n = intervals.length;
        int count = 0;
        int temp [] = intervals[0];
        int i =1;
        while(i < n)
        {
            while( i < n && temp[1] > intervals[i][0])
            {
                i++;
                count++;
                continue;
            }
            if(i < n)
                temp = intervals[i];
            i++;

        }
        return count;
    }
}