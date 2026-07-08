from bisect import bisect_left, bisect_right
from typing import List

class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7

        pos = []
        digits = []

        for i, ch in enumerate(s):
            if ch != '0':
                pos.append(i)
                digits.append(int(ch))

        m = len(digits)

        if m == 0:
            return [0] * len(queries)

        pow10 = [1] * (m + 1)
        for i in range(1, m + 1):
            pow10[i] = pow10[i - 1] * 10 % MOD

        prefSum = [0] * (m + 1)
        prefNum = [0] * (m + 1)

        for i in range(m):
            prefSum[i + 1] = prefSum[i] + digits[i]
            prefNum[i + 1] = (prefNum[i] * 10 + digits[i]) % MOD

        ans = []

        for l, r in queries:
            L = bisect_left(pos, l)
            R = bisect_right(pos, r)

            if L == R:
                ans.append(0)
                continue

            cnt = R - L
            val = (prefNum[R] - prefNum[L] * pow10[cnt]) % MOD
            ssum = prefSum[R] - prefSum[L]

            ans.append(val * ssum % MOD)

        return ans