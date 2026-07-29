class Solution {
    private static final long LIMIT = 1_000_001L;

    private long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);

        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= LIMIT) return LIMIT;
        }
        return Math.min(ans, LIMIT);
    }

    private long countWays(int[] cnt) {
        int rem = 0;
        for (int x : cnt) rem += x;

        long ways = 1;

        for (int x : cnt) {
            if (x == 0) continue;
            ways *= comb(rem, x);
            if (ways >= LIMIT) ways = LIMIT;
            rem -= x;
        }

        return ways;
    }

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
        }

        if (countWays(half) < k) return "";

        int halfLen = s.length() / 2;
        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();
        return left.toString() + mid + right;
    }
}