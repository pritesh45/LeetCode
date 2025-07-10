class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        int index=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=nums[index]){
                index++;
                nums[index]=nums[j];
                
            }
        }
        return index+1;
    }
}