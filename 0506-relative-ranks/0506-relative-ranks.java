class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n=score.length;
        String[] result=new String[n];

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            pq.add(new int[]{score[i],i});
        }
        String[] medals={"Gold Medal","Silver Medal","Bronze Medal"};
        int rank=1;
        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int index=top[1];

            if(rank<=3){
                result[index]=medals[rank-1];
            }
            else{
                result[index]=String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }
}