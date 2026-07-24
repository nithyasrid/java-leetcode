class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[2048];
        for (int x : nums) {
            present[x] = true;
        }

        boolean[] cur = new boolean[2048];
        cur[0] = true;

        for (int step = 0; step < 3; step++) {
            boolean[] next = new boolean[2048];
            for (int x = 0; x < 2048; x++) {
                if (!present[x]) continue;
                for (int y = 0; y < 2048; y++) {
                    if (cur[y]) {
                        next[x ^ y] = true;
                    }
                }
            }
            cur = next;
        }

        int ans = 0;
        for (boolean b : cur) {
            if (b) ans++;
        }
        return ans;
    }
}