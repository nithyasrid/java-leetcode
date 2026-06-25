class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        n = len(nums)

        pref = [0] * (n + 1)
        for i in range(n):
            pref[i + 1] = pref[i] + (1 if nums[i] == target else -1)

        ans = 0
        for i in range(n + 1):
            for j in range(i + 1, n + 1):
                if pref[j] > pref[i]:
                    ans += 1

        return ans