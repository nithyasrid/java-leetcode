class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // need faster
            }
        }

        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        
        for (int pile : piles) {
            // ceil division
            hours += (pile + k - 1) / k;
        }
        
        return hours <= h;
    }
}