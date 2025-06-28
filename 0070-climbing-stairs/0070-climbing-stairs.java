class Solution {
    static int fun(int n, int index,int[] dp) {
        if (index == n) {
            return 1;
        }
        if (index > n) {
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int left = fun(n, index + 1,dp);
        int right = fun(n, index + 2,dp);
        dp[index]= left + right;
        return dp[index];
    }

    public int climbStairs(int n) {
    int[] dp=new int[n+1];
    Arrays.fill(dp,-1);

        return fun(n, 0,dp);

    }
}
