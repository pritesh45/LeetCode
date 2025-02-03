class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int max1=nums1[0];
        for(int i=1;i<nums1.length;i++){
            if(max1<nums1[i]){
                max1=nums1[i];
            }
        }
        int max2=nums2[0];
        for(int i=1;i<nums2.length;i++){
            if(max2<nums2[i]){
                max2=nums2[i];
            }
        }
        return max2-max1;
    }
}