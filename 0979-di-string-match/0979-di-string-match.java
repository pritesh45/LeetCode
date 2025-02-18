class Solution {
    public int[] diStringMatch(String s) {
        int low=0;
        int high=s.length();
        int[] ans=new int[high+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                ans[i]=low;
                low++;
            }
            else{
                ans[i]=high;
                high--;
            }
        }
        ans[ans.length-1] =high;
        return ans;
        
    }
}