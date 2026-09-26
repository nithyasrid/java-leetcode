class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < points.length; i++) {

            // Remove points whose x-distance exceeds k
            while (!deque.isEmpty() && points[i][0] - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            // Calculate the maximum equation value
            if (!deque.isEmpty()) {
                int current = points[i][1]
                            + deque.peekFirst()[1]
                            + points[i][0]
                            - deque.peekFirst()[0];

                result = Math.max(result, current);
            }

            // Maintain decreasing order of (y - x)
            while (!deque.isEmpty() &&
                    (points[i][1] - points[i][0]) >=
                    (deque.peekLast()[1] - deque.peekLast()[0])) {
                deque.pollLast();
            }

            deque.offerLast(points[i]);
        }

        return result;
    }
}