class Solution {
    public boolean canJump(int[] nums) {
        //let's keep maxReach in starting is 0
        int  maxReach = 0;

        for(int i=0;i<nums.length;i++){
            if(i>maxReach){
                return false;
            }
            maxReach= Math.max(maxReach,i+nums[i]);
        }
        return true;
    }
}