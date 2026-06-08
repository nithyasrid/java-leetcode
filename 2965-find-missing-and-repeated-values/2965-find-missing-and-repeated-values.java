class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n= grid.length;
        int total  = n*n;
        int freq[] = new int[total+1];
        int repeated =-1;
        int missing = -1;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                int num = grid[i][j];
                freq[num ]+=1;

            }
            
            for(int nums = 1;nums<= total ;nums ++){
                if(freq[nums]==2){
                    repeated = nums ;
                }
                else if (freq[nums ]==0){
                    missing = nums ;
                }
            }
        }
        return new int[]{repeated, missing};
        
    }}