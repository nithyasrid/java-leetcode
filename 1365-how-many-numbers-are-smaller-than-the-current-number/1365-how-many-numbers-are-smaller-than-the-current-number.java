class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<sorted.length;i++){
            map.putIfAbsent(sorted[i],i);
        }
        int[] result = new int[nums.length];
        for(int i =0 ;i<nums.length;i++){
            result[i]=map.get(nums[i]);
        }
        return result;
    }
}