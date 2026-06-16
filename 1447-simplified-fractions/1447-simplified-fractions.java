class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for(int den = 2;den<=n;den++){
            for(int numer = 1;numer < den;numer++){
                if(gcd(numer,den)==1){
                    result.add(numer + "/" + den);
                }
            }
        }
        return result ;
    }
    private int gcd(int a , int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}