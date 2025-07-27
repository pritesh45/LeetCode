class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        int index=0;
    for(int i=1;i<nums.length-1;i++){
        if((nums[index]<nums[i] && nums[i]>nums[i+1]) || nums[index]>nums[i]&& nums[i]<nums[i+1]){
            count++;
            index=i;
        }
    }
    return count;
        
    }
}