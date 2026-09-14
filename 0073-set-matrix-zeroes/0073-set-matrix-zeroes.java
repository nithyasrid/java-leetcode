class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length ;
        int col = matrix[0].length;
        boolean[] zrow = new boolean[row];
        boolean[] zcol = new boolean[col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j]==0){
                    zrow[i] = true;
                    zcol[j] = true;

                }
            }
        }
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(zrow[i] || zcol[j]){
                    matrix[i][j] =0;
                }
            }
        }
    }
}