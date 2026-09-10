class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        boolean[] zerorows = new boolean[rows];
        boolean[] zerocol = new boolean[col];

        for(int i =0;i<rows;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j] == 0){
                    zerorows[i] = true;
                    zerocol[j] = true;
                }
            }
        }
        for(int i=0 ;i<rows;i++){
            for(int j=0;j<col;j++){
                if(zerorows[i] || zerocol[j]){
                    matrix[i][j] = 0;
                }            
            }
        }
    }
}