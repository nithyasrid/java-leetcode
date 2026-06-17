class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for(int d =2 ;d<=n;d++){
            for(int numer = 1 ;numer<d;numer++){
                if(gcd(numer,d) ==1){
                    result .add(numer + "/" +d);
                }
            }
        }
        return result ;
    }
    public int gcd(int a , int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp ;
        }
    return a ;
    }
}