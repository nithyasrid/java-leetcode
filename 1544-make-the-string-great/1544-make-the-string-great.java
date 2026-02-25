class Solution {
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            int len = stack.length();
            if (len > 0) {
                char top = stack.charAt(len - 1);

                // If same letter but different case, remove the pair
                if (Math.abs(top - curr) == 32) {
                    stack.deleteCharAt(len - 1);
                    continue;
                }
            }

            stack.append(curr);
        }

        return stack.toString();
    }
}