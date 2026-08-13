class Solution:
    class Node:
        def __init__(self):
            self.length = 0
            self.pref = 0
            self.suff = 0
            self.best = 0
            self.leftChar = ''
            self.rightChar = ''

    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        s = list(s)
        n = len(s)
        seg = [self.Node() for _ in range(4 * n)]

        def merge(L, R):
            res = self.Node()

            res.length = L.length + R.length
            res.leftChar = L.leftChar
            res.rightChar = R.rightChar

            # Prefix
            res.pref = L.pref
            if L.pref == L.length and L.rightChar == R.leftChar:
                res.pref += R.pref

            # Suffix
            res.suff = R.suff
            if R.suff == R.length and L.rightChar == R.leftChar:
                res.suff += L.suff

            # Best
            res.best = max(L.best, R.best)
            if L.rightChar == R.leftChar:
                res.best = max(res.best, L.suff + R.pref)

            return res

        def build(idx, l, r):
            if l == r:
                node = seg[idx]
                node.length = 1
                node.pref = 1
                node.suff = 1
                node.best = 1
                node.leftChar = s[l]
                node.rightChar = s[l]
                return

            mid = (l + r) // 2
            build(idx * 2, l, mid)
            build(idx * 2 + 1, mid + 1, r)
            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1])

        def update(idx, l, r, pos, ch):
            if l == r:
                node = seg[idx]
                node.length = 1
                node.pref = 1
                node.suff = 1
                node.best = 1
                node.leftChar = ch
                node.rightChar = ch
                return

            mid = (l + r) // 2
            if pos <= mid:
                update(idx * 2, l, mid, pos, ch)
            else:
                update(idx * 2 + 1, mid + 1, r, pos, ch)

            seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1])

        build(1, 0, n - 1)

        ans = []
        for ch, pos in zip(queryCharacters, queryIndices):
            s[pos] = ch
            update(1, 0, n - 1, pos, ch)
            ans.append(seg[1].best)

        return ans