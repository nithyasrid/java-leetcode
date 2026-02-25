class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);

            // remove same chars from the left
            while (left <= right && s.charAt(left) == ch) {
                left++;
            }

            // remove same chars from the right
            while (left <= right && s.charAt(right) == ch) {
                right--;
            }
        }

        return right - left + 1;
    }
}