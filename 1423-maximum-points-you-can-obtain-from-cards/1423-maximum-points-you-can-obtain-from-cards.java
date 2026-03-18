class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }

        // If taking all cards
        if (k == n) return totalSum;

        int windowSize = n - k;
        int windowSum = 0;

        // initial window
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        // sliding window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, windowSum);
        }

        return totalSum - minSum;
    }
}