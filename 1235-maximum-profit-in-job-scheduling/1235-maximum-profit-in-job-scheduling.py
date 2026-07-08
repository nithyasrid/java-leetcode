from typing import List
import bisect

class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = sorted(zip(startTime, endTime, profit))
        starts = [s for s, _, _ in jobs]

        n = len(jobs)
        dp = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            j = bisect.bisect_left(starts, jobs[i][1])
            dp[i] = max(dp[i + 1], jobs[i][2] + dp[j])

        return dp[0]