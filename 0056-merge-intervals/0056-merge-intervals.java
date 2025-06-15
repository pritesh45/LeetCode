class Solution {
    public int[][] merge(int[][] intervals) {
        //sorting based on start time
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        //pointer for the position in merged array
        int index=0;
        //iterate through intervals and merge
        for(int i=1;i<intervals.length;i++){
            if(intervals[index][1]>=intervals[i][0]){
                //merge intervals
                intervals[index][1]=Math.max(intervals[index][1],intervals[i][1]);
            }else{
                //move to next interval
                index++;
                intervals[index]=intervals[i];
            }
        }  
        return Arrays.copyOf(intervals,index+1);
    }
}