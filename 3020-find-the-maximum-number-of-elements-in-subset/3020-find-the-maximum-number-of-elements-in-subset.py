class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        from collections import Counter

        cnt = Counter(nums)
        ans = 1

        # Handle 1 separately
        if 1 in cnt:
            c = cnt[1]
            ans = max(ans, c if c % 2 == 1 else c - 1)

        for x in cnt:
            if x == 1:
                continue

            cur = x
            length = 0

            while cnt.get(cur, 0) >= 2:
                length += 2
                cur *= cur

            if cnt.get(cur, 0) == 1:
                length += 1
            else:
                length = max(1, length - 1)

            ans = max(ans, length)

        return ans