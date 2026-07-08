from typing import List
import bisect

class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = sorted(zip(endTime, startTime, profit))

        ends = [0]
        dp = [0]

        for e, s, p in jobs:
            i = bisect.bisect_right(ends, s) - 1
            cur = dp[i] + p

            if cur > dp[-1]:
                ends.append(e)
                dp.append(cur)

        return dp[-1]