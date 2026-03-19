class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        if ((long)m * k > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1; // try smaller days
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int count = 0, bouquets = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}