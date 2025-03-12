class Solution {
    static int find(int[]dp,int n,int ind){
        if(ind==n){
            return 1;
        }
        if(ind>n){
            return 0;
        }
        if(dp[ind]!=-1)
        return dp[ind];
        int left=find(dp,n,ind+1);
        int right=find(dp,n,ind+2);
        return  dp[ind]=left+right;
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return find(dp,n,0);
        
    }
}