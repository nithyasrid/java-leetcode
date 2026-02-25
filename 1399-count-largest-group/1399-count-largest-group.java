class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[37]; 

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            freq[sum]++;
        }

        int maxSize = 0;
        int count = 0;

        for (int size : freq) {
            if (size > maxSize) {
                maxSize = size;
                count = 1;
            } else if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}