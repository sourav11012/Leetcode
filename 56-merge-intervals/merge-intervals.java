class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while(i < n)
        {
            int[] temp = intervals[i];
            int j = i;
             while(j < n-1 && temp[1] >= intervals[j+1][0])
                {
                    temp[0] = Math.min(temp[0], intervals[j+1][0]);
                    temp[1] = Math.max(temp[1], intervals[j+1][1]);
                    j++;
                }
            i = j + 1;
            result.add(temp);

        }
        int[][] out = new int[result.size()][2];
        i = 0;
        for(i = 0; i< result.size();i++)
        {
            out[i] = result.get(i);
        }
        return out;

       
    }
}