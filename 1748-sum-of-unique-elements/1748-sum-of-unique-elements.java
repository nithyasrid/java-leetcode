import java.util.*;

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }
}