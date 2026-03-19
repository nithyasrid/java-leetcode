class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n
        
        // 1. reverse whole array
        reverse(nums, 0, n - 1);
        
        // 2. reverse first k elements
        reverse(nums, 0, k - 1);
        
        // 3. reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}