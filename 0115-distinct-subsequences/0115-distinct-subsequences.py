class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n = len(s)
        m = len(t)

        dp =[[0]*(m+1) for _ in range(n+1)]
        for i in range(n+1):
            dp[i][0] = 1
        for i in range(1,n+1):
            for j in range(1,m+1):
                non_pick  = dp[i-1][j]
                pick =0
                if s[i-1] == t[j-1]:
                    pick = dp[i-1][j-1]
                dp[i][j] = non_pick+pick
        return dp[i][j]
