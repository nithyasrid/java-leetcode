from math import gcd

class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        prefix_gcd = []
        max_so_far = 0

        # Build prefixGcd array
        for num in nums:
            max_so_far = max(max_so_far, num)
            prefix_gcd.append(gcd(num, max_so_far))

        # Sort the array
        prefix_gcd.sort()

        # Pair smallest with largest
        left, right = 0, len(prefix_gcd) - 1
        ans = 0

        while left < right:
            ans += gcd(prefix_gcd[left], prefix_gcd[right])
            left += 1
            right -= 1

        return ans