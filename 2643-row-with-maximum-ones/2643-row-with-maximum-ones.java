class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRow =0;
        int maxOne = 0;
        for(int i =0;i<mat.length;i++){
            int count =0;
            for(int j =0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    count+=1;
                }
            }
            if(count>maxOne){
                maxOne = count ;
                maxRow = i ;
            }
        }
        return new int[]{maxRow ,maxOne};
        
    }
}