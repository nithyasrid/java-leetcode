import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // if no overlap
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } 
            else {
                // merge intervals
                result.get(result.size() - 1)[1] = Math.max(
                    result.get(result.size() - 1)[1],
                    interval[1]
                );
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}