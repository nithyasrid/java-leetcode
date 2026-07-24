import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);

        HashSet<Integer> possible = new HashSet<>();
        possible.add(0);

        for (int step = 0; step < 3; step++) {
            HashSet<Integer> next = new HashSet<>();
            for (int x : values) {
                for (int y : possible) {
                    next.add(x ^ y);
                }
            }
            possible = next;
        }

        return possible.size();
    }
}