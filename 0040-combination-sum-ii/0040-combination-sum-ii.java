import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 1. sort first
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] arr, int target, int start, 
                           List<Integer> temp, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            
            // 2. skip duplicates (same recursion level)
            if (i > start && arr[i] == arr[i - 1]) continue;
            
            // 3. pruning (since sorted)
            if (arr[i] > target) break;
            
            // choose
            temp.add(arr[i]);
            
            // move to next index (i+1 → cannot reuse same element)
            backtrack(arr, target - arr[i], i + 1, temp, result);
            
            // undo
            temp.remove(temp.size() - 1);
        }
    }
}