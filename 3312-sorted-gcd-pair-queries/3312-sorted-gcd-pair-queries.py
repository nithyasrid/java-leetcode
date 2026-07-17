from typing import List
from bisect import bisect_right

class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        MAX = max(nums)

        # Step 1: Frequency of each number
        freq = [0] * (MAX + 1)
        for x in nums:
            freq[x] += 1

        # Step 2: Count numbers divisible by each gcd candidate
        divisible = [0] * (MAX + 1)
        for g in range(1, MAX + 1):
            for multiple in range(g, MAX + 1, g):
                divisible[g] += freq[multiple]

        # Step 3: Count pairs with gcd exactly g
        exact = [0] * (MAX + 1)
        for g in range(MAX, 0, -1):
            cnt = divisible[g]
            pairs = cnt * (cnt - 1) // 2

            for multiple in range(2 * g, MAX + 1, g):
                pairs -= exact[multiple]

            exact[g] = pairs

        # Step 4: Prefix sums
        prefix = [0] * (MAX + 1)
        for g in range(1, MAX + 1):
            prefix[g] = prefix[g - 1] + exact[g]

        # Step 5: Answer queries
        ans = []
        for q in queries:
            ans.append(bisect_right(prefix, q))

        return ans