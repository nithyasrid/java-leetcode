class Solution:
    def subsequencePairCount(self, nums: List[int]) -> int:
        @cache
        def helper(idx, gd1, gd2):
            if idx == len(nums):
                if gd1 == gd2:
                    return 1
                else:
                    return 0
            return helper(idx+1, gd1, gd2) + helper(idx+1, gcd(gd1, nums[idx]), gd2) + helper(idx+1, gd1, gcd(gd2, nums[idx]))
        return (helper(0, 0, 0) - 1) % (10**9 + 7)
        