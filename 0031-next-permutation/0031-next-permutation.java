class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // 1. Find breakpoint
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // 2. If breakpoint exists
        if (i >= 0) {
            int j = n - 1;
            
            // find next greater element
            while (nums[j] <= nums[i]) {
                j--;
            }
            
            swap(nums, i, j);
        }
        
        // 3. Reverse right part
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}