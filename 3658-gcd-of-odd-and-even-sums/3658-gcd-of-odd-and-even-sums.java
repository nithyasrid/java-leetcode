class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sum_odd = n * n;
        int sum_even = n * (n + 1);

        return gcd(sum_odd, sum_even);
    }

    public int gcd(int sum_odd, int sum_even) {
        while (sum_even != 0) {
            int temp = sum_even;
            sum_even = sum_odd % sum_even;
            sum_odd = temp;
        }
        return sum_odd;
    }
}