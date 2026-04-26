import java.util.*;

class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] state = new boolean[101]; // index 1 to 100

        // Toggle bulbs
        for (int b : bulbs) {
            state[b] = !state[b];
        }

        // Collect bulbs that are ON
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (state[i]) {
                result.add(i);
            }
        }

        return result;
    }
}