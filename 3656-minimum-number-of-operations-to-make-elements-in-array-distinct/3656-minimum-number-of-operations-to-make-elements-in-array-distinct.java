class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int index=-1;
        for(int i=nums.length-1; i>=0; i--){
            if(set.contains(nums[i])){
                index=i;
                break;
            }
            set.add(nums[i]);
        }
        if(index== -1){
            return 0;
        }
        index++;
        int rem=index % 3;
        return (rem == 0)? index/3:(index/3)+1;
    }
}