class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> count=new HashMap<>();

        for(int fruit:basket1) count.put(fruit,count.getOrDefault(fruit,0)+1);
        for(int fruit:basket2) count.put(fruit,count.getOrDefault(fruit,0)-1);

        List<Integer> surplus = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            int diff=entry.getValue();
            if(diff%2!=0) return -1;

            for(int i=0;i<Math.abs(diff)/2;i++){
                surplus.add(entry.getKey());
            }
        }

        int minVal=Integer.MAX_VALUE;
        for(int val:basket1) minVal= Math.min(minVal,val);
        for(int val:basket2) minVal= Math.min(minVal,val);

        Collections.sort(surplus);

        long cost =0;
        int n=surplus.size();
        for(int i=0;i<n/2;i++){
            int a=surplus.get(i);
            int b=surplus.get(n-i-1);
            cost += Math.min(Math.min(a,b),2*minVal);
        }
    return cost;
        
    }
}