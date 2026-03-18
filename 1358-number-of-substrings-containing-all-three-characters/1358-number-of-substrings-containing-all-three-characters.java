class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // a, b, c
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;

            // shrink while valid
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right;

                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}