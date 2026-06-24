class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10**9 + 7
        m = r - l + 1
        D = 2 * m

        # Generate first few terms of the sequence.
        need = 2 * D + 5
        seq = [m % MOD]

        if need > 1:
            up = [i for i in range(m)]          # length 2, last move was up
            down = [m - 1 - i for i in range(m)]  # length 2, last move was down
            seq.append(m * (m - 1) % MOD)

            while len(seq) < need:
                nu = [0] * m
                nd = [0] * m

                s = 0
                for i in range(m):
                    nu[i] = s
                    s += down[i]
                    if s >= MOD:
                        s -= MOD

                s = 0
                for i in range(m - 1, -1, -1):
                    nd[i] = s
                    s += up[i]
                    if s >= MOD:
                        s -= MOD

                up, down = nu, nd
                seq.append((sum(up) + sum(down)) % MOD)

        idx = n - 1
        if idx < len(seq):
            return seq[idx]

        # Solve for an order-D recurrence:
        # a[k] = c0*a[k-1] + c1*a[k-2] + ... + c[D-1]*a[k-D]
        A = [[0] * (D + 1) for _ in range(D)]
        for r0 in range(D):
            t = D + r0
            row = A[r0]
            for j in range(D):
                row[j] = seq[t - 1 - j]
            row[D] = seq[t]

        where = [-1] * D
        row = 0

        for col in range(D):
            pivot = row
            while pivot < D and A[pivot][col] == 0:
                pivot += 1
            if pivot == D:
                continue

            A[row], A[pivot] = A[pivot], A[row]
            where[col] = row

            inv = pow(A[row][col], MOD - 2, MOD)
            rr = A[row]
            for j in range(col, D + 1):
                rr[j] = rr[j] * inv % MOD

            for i in range(D):
                if i != row and A[i][col]:
                    fac = A[i][col]
                    ri = A[i]
                    for j in range(col, D + 1):
                        ri[j] = (ri[j] - fac * rr[j]) % MOD

            row += 1

        coef = [0] * D
        for col in range(D):
            if where[col] != -1:
                coef[col] = A[where[col]][D]

        init = seq[:D]

        # Kitamasa: compute the idx-th term.
        def kth(k: int) -> int:
            if k < D:
                return init[k]

            def combine(a, b):
                res = [0] * (2 * D)

                for i, ai in enumerate(a):
                    if ai == 0:
                        continue
                    for j, bj in enumerate(b):
                        if bj:
                            res[i + j] = (res[i + j] + ai * bj) % MOD

                for i in range(2 * D - 2, D - 1, -1):
                    x = res[i]
                    if x == 0:
                        continue
                    for j, c in enumerate(coef):
                        if c:
                            res[i - 1 - j] = (
                                res[i - 1 - j] + x * c
                            ) % MOD

                return res[:D]

            pol = [1] + [0] * (D - 1)
            e = [0] * D
            if D == 1:
                e[0] = coef[0]
            else:
                e[1] = 1

            p = k
            while p:
                if p & 1:
                    pol = combine(pol, e)
                e = combine(e, e)
                p >>= 1

            ans = 0
            for i in range(D):
                ans = (ans + pol[i] * init[i]) % MOD
            return ans

        return kth(idx)