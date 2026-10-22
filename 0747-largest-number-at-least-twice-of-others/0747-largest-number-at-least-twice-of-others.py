class Solution:
    def dominantIndex(self, nums: list[int]) -> int:
        n=sorted(nums)
        if n[-1]>=2*n[-2]:
            return nums.index(n[-1])
        return -1