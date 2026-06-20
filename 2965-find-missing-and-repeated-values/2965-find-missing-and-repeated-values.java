class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
         int n = grid.length;
         int total = n*n ;
         int[] fre = new int[total+1];
         for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                int num = grid[i][j];
                fre[num ]+=1;
            }
         }
         int repeated = -1;
         int missing = -1;
         for(int k =0;k<=total ;k++){
            if(fre[k]==2){
                repeated = k;
            }
            else if(fre[k]==0){
                missing = k;
            }
         }

         return new int[]{repeated,missing};
    }
}