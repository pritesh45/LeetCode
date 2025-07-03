class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            list.add(nums2[j]);
        }
        Collections.sort(list);
        int len=list.size();
        if(len %2!=0){
            return list.get(len/2);
        }
        return (double)(list.get(len/2-1)+list.get(len/2))/2;
       // return med;
    }
}