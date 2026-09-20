class Solution {
    public int reverseDegree(String s) {
        int sum =0;
        for(int i =0;i<s.length();i++){
            int x = 123 - s.charAt(i);
            int mul = x*(i+1);
            sum = sum+mul;
        }
        return sum;

    }
}