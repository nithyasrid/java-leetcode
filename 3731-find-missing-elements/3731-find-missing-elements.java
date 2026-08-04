class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       List<Integer> ans = new ArrayList<>();

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Check every number in the range
        for (int i = min; i <= max; i++) {
            boolean found = false;

            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                ans.add(i);
            }
        }

        return ans; 
    }
}