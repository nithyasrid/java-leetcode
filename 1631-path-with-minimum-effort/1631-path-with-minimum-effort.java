import java.util.*;

class Solution {

    private static int[][] DIR = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;

        if (n == 0) {
            return 0;
        }

        int m = heights[0].length;

        if (m == 0) {
            return 0;
        }

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.add(new int[] {0, 0, 0});
        dp[0][0] = 0;

        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int effort = p[0];
            int x = p[1];
            int y = p[2];

            if (x == (n - 1) && y == (m - 1)) {
                return effort;
            }

            for (int[] dir : DIR) {

                int x1 = x + dir[0];
                int y1 = y + dir[1];

                if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) {
                    continue;
                }

                int moveEffort =
                    Math.abs(heights[x][y] - heights[x1][y1]);

                int newEffort = Math.max(effort, moveEffort);

                if (dp[x1][y1] > newEffort) {
                    dp[x1][y1] = newEffort;

                    pq.add(new int[] {
                        newEffort,
                        x1,
                        y1
                    });
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}