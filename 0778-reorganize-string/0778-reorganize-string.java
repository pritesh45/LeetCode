class Solution {
    public String reorganizeString(String s) {
        //Hashmap create and finding the freq of each character
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(char c:s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        //priority queue 
     PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());
        StringBuilder sb=new StringBuilder();
        while(maxHeap.size()>=2){
            char char1=maxHeap.poll();
            char char2=maxHeap.poll();
            
            sb.append(char1);
            sb.append(char2);

            freqMap.put(char1,freqMap.get(char1)-1);
            freqMap.put(char2,freqMap.get(char2)-1);

            if(freqMap.get(char1)>0) maxHeap.add(char1);
            if(freqMap.get(char2)>0) maxHeap.add(char2);
        }

        if(!maxHeap.isEmpty()){
            char ch=maxHeap.poll();
            if(freqMap.get(ch)>1) return "";
            sb.append(ch);
        }
        return sb.toString();
        
    }
}