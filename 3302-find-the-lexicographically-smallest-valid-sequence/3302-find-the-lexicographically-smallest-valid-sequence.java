class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suf[i] = earliest position in word2 that still needs to be matched
        // using word1[i...n-1] without any modification.
        int[] suf = new int[n + 1];
        int j = m - 1;
        suf[n] = m;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
                }
        int[] ans = new int[m];
        boolean used = false;
        int i = 0;

        for (int k = 0; k < m; k++) {
            boolean found = false;

            while (i < n) {
                if (word1.charAt(i) == word2.charAt(k)) {
                    ans[k] = i;
                    i++;
                    found = true;
                    break;
                }

                if (!used && suf[i + 1] <= k + 1) {
                    used = true;
                    ans[k] = i;
                    i++;
                    found = true;
                    break;
                }

                i++;
            }

            if (!found) return new int[0];
        }

        return ans;
    }
}