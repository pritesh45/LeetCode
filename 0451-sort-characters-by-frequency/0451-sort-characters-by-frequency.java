class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(char ch:s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->freqMap.get(b)-freqMap.get(a));
        pq.addAll(freqMap.keySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            int freq=freqMap.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}