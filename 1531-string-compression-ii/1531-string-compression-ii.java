class Solution {
    int n;
    String s;
    Integer[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        this.n = s.length();
        dp = new Integer[n][k + 1];
        return solve(0, k);
    }

    private int solve(int i, int k) {
        if (k < 0) return Integer.MAX_VALUE / 2;
        if (i >= n) return 0;

        if (dp[i][k] != null) return dp[i][k];

        
        int ans = solve(i + 1, k - 1);

        int same = 0;
        int diff = 0;

        for (int j = i; j < n; j++) {
            if (s.charAt(j) == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }

            if (diff > k) break;

            ans = Math.min(ans, getCompressedLength(same) + solve(j + 1, k - diff));
        }

        dp[i][k] = ans;
        return ans;
    }

    private int getCompressedLength(int count) {
        if (count == 1) return 1;
        if (count < 10) return 2;
        if (count < 100) return 3;
        return 4;
    }
}