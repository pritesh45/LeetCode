class Solution {
    public int maxArea(int[] height) {
        int maxarea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int width=right-left;
            int currentheight=Math.min(height[left],height[right]);
            int currentarea=width*currentheight;
            maxarea=Math.max(maxarea,currentarea);
            if(height[left]<height[right]){
                left++;

            }
            else{ 
                right--;
            }
        }
        return maxarea;
    }
}

