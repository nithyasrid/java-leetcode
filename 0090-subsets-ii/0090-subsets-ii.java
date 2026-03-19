import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // required for duplicate handling
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] nums, int start, 
                           List<Integer> temp, List<List<Integer>> result) {
        
        // add current subset
        result.add(new ArrayList<>(temp));
        
        for (int i = start; i < nums.length; i++) {
            
            // skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}