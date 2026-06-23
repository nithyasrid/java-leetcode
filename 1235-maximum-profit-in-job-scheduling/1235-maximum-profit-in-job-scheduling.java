class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort by start time
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = jobs[i][0];
        }

        int[] dp = new int[n + 1];

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            int next = lowerBound(starts, jobs[i][1]);

            int take = jobs[i][2] + dp[next];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = arr.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}