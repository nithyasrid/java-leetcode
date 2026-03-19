class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            // swap when negative
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}