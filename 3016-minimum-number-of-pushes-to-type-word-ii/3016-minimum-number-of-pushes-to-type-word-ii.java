class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int cost = 1;

        for (int i = 25, cnt = 0; i >= 0 && freq[i] > 0; i--, cnt++) {
            if (cnt > 0 && cnt % 8 == 0) {
                cost++;
            }
            ans += freq[i] * cost;
        }

        return ans;
    }
}