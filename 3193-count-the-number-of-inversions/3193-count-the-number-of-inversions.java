import java.util.*;

class Solution {
    
    static final int MOD = 1000000007;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];
        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        int maxInv = 400;

        long[][] dp = new long[n + 1][maxInv + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= maxInv; j++) {

                long sum = 0;

                for (int k = 0; k <= Math.min(j, i - 1); k++) {
                    sum = (sum + dp[i - 1][j - k]) % MOD;
                }

                dp[i][j] = sum;
            }

            if (req[i - 1] != -1) {
                int need = req[i - 1];
                for (int j = 0; j <= maxInv; j++) {
                    if (j != need) dp[i][j] = 0;
                }
            }
        }

        long ans = 0;

        for (int j = 0; j <= maxInv; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }

        return (int) ans;
    }
}