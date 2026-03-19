class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDivide(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1; // try smaller divisor
            } else {
                low = mid + 1; // need larger divisor
            }
        }

        return ans;
    }

    private boolean canDivide(int[] nums, int threshold, int d) {
        long sum = 0;
        
        for (int num : nums) {
            sum += (num + d - 1) / d; // ceil division
        }
        
        return sum <= threshold;
    }
}