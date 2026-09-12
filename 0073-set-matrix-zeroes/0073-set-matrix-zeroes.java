class Solution {
    public void setZeroes(int[][] matrix) {
        int rows =matrix.length;
        int col = matrix[0].length;
        boolean[] zrow = new boolean[rows];
        boolean[] zcol = new boolean[col];
        for(int i =0;i<rows;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j] == 0){
                    zrow[i] = true;
                    zcol[j] = true;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j =0;j<col;j++){
                if(zrow[i]||zcol[j]){
                    matrix[i][j] = 0;

                }

            }
        }
    }
}