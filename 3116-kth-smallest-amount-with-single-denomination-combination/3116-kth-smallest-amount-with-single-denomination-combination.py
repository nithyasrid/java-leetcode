from math import gcd

class Solution:
    def findKthSmallest(self, coins: list[int], k: int) -> int:
        # Sort and remove redundant denominations.
        # If 3 exists, then 6, 9, ... don't add any new amounts.
        coins.sort()

        nums = []
        for coin in coins:
            if not any(coin % x == 0 for x in nums):
                nums.append(coin)

        n = len(nums)

        def count(x: int) -> int:
            """Count distinct amounts <= x divisible by at least one coin."""
            total = 0

            for mask in range(1, 1 << n):
                lcm = 1
                bits = 0

                for i in range(n):
                    if mask & (1 << i):
                        bits += 1
                        lcm = lcm * nums[i] // gcd(lcm, nums[i])

                        # No contribution if LCM exceeds x
                        if lcm > x:
                            break

                if lcm > x:
                    continue

                if bits % 2 == 1:
                    total += x // lcm
                else:
                    total -= x // lcm

            return total

        # The kth number is at most k * smallest_coin
        left, right = 1, coins[0] * k

        while left < right:
            mid = (left + right) // 2

            if count(mid) >= k:
                right = mid
            else:
                left = mid + 1

        return left