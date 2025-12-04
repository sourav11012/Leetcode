class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) return result.toArray(new int[0][]);

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] it : intervals)
        {
            if(it[0] <= end )
            {
                end = Math.max(end, it[1]);
            }else{
                result.add(new int[]{start, end});
                start = it[0];
                end = it[1];
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}