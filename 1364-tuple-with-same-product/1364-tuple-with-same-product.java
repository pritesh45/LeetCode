class Solution {
    public int tupleSameProduct(int[] nums) {
        int count=0;
        Map<Integer,Integer> productmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product=nums[i]*nums[j];
                productmap.put(product,productmap.getOrDefault(product,0)+1);
            }
        }
        for(int freq: productmap.values()){
            if(freq>1){
                count+=8*(freq*(freq-1))/2;
            }
        }
        return count;
    }
}