class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (pref[j] > pref[i]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}