class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int n:nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }
       List<Integer> list=new ArrayList<>();
       for(int n:nums){
        list.add(n);
       }
       Collections.sort(list,(a,b)->{
        if(freqMap.get(a).equals(freqMap.get(b))){
            return b-a;
        }else{
            return freqMap.get(a)-freqMap.get(b);
        }
       });
       int[] ans=new int[nums.length];
       for(int i=0;i<list.size();i++){
        ans[i]=list.get(i);
       }
        
        return ans;
        
    }
}