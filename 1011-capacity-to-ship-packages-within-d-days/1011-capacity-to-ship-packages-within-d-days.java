class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        
        for (int w : weights) {
            low = Math.max(low, w); // max weight
            high += w;              // total sum
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1;  // need bigger capacity
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                usedDays++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return usedDays <= days;
    }
}