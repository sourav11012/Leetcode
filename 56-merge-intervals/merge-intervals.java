class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[] current = intervals[0];
        result.add(current);

        for(int[] interval : intervals)
        {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart)
            {
                current[1] = Math.max(currentEnd, nextEnd);

            }else{
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}