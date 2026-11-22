class Solution {
    public int[][] insert(int[][] intervals, int[] newIntervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1] < newIntervals[0]){
            res.add(intervals[i]);
            i++;
        }

        while(i<n && newIntervals[1] >= intervals[i][0]){
            newIntervals[0] = Math.min(newIntervals[0], intervals[i][0]);
            newIntervals[1] = Math.max(newIntervals[1], intervals[i][1]);
            i++;
        }

        res.add(newIntervals);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
