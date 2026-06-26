class Solution {
    class BIT {
        long[] bit;
        int n;

        BIT(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        int[] vals = pref.clone();
        Arrays.sort(vals);

        int m = 1;
        for (int i = 1; i <= n; i++) {
            if (vals[i] != vals[m - 1]) {
                vals[m++] = vals[i];
            }
        }

        BIT bit = new BIT(m);
        long ans = 0;

        for (int x : pref) {
            int idx = lowerBound(vals, m, x) + 1;

            ans += bit.sum(idx - 1);
            bit.add(idx, 1);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int len, int target) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}