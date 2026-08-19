import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Store reserved seats for each row as a bitmask.
        Map<Integer, Integer> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Use bit (col - 1) for seat col.
            reserved.put(row, reserved.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        // All rows without reservations can accommodate 2 groups.
        int answer = (n - reserved.size()) * 2;

        // Masks for the three possible groups.
        int left = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);   // 2-5
        int middle = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6); // 4-7
        int right = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);  // 6-9

        for (int mask : reserved.values()) {
            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                // Can use 2-5 and 6-9.
                answer += 2;
            } else if (canLeft || canMiddle || canRight) {
                // At least one block is available.
                answer += 1;
            }
        }

        return answer;
    }
}