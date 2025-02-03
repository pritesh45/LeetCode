class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int max=Math.abs(nums[0]-nums[n-1]);
        for(int i=1;i<n;i++){
            int max1=Math.abs(nums[i]-nums[i-1]);
            max=Math.max(max,max1);
        }
        return max;
    }
}