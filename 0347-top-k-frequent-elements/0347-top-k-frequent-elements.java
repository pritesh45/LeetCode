class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->freqMap.get(a)-freqMap.get(b));

        for(int num:freqMap.keySet()){
            pq.offer(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
    return res;
        
    }
}