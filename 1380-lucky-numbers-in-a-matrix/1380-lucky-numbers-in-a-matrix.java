class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        
        for (int i = 0; i < m; i++) {
            int rowMin = matrix[i][0];
            int colIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isMax = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][colIndex] > rowMin) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) result.add(rowMin);
        }

        return result;
    }
}