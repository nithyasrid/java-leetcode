class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele :nums){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        int gcd = 1;
        for(int i=2;i<=Math.min(min, max );i++){
            if(min%i ==0 && max%i ==0 ){
                gcd =  i ;
            }
        }
        return gcd;
    }
}