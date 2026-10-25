class Solution {
    public int maximumStrongPairXor(int[] nums) {

        int max = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int numI = nums[i];

            for (int j = i; j < len; j++) {

                if (Math.abs(numI - nums[j]) <= Math.min(numI, nums[j])) {
                    max = Math.max(max, numI ^ nums[j]);
                }
            }
        }

        return max;
    }
}