class Solution {
    public int lastStoneWeightII(int[] stones) {
        int S=0;
        for(int i: stones)
            S+=i;
        int S2=0;
        int n=stones.length;
        //maximise S2
        boolean[][] dp = new boolean[S/2 +1][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i]=true;
        //zero sum is always possible(just dont take any element in the array)
        
        for(int i=1;i<=n;i++)
        {
            for(int s=1;s<=S/2;s++)
            {
                if(dp[s][i-1] || (s>=stones[i-1] &&dp[s-stones[i-1]][i-1]))
                {
                    dp[s][i]=true;
                    S2=Math.max(s,S2);
                }
                
            }
        }
        return S-2*S2;
        
    }
}