class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n*n;
        int[] freq = new int[total+1];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                int num = grid[i][j];
                freq[num ] +=1;
            }
        }
            int repeated =-1;
            int missing= -1;
            for(int i=0;i<=total;i++){
                if(freq[i]==2){
                    repeated = i;
                }
                else if(freq[i]==0){
                    missing =i;
                }
            }
            
        
        return new int[]{repeated,missing};
    }
}