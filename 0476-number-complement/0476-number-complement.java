class Solution {
    public int findComplement(int num) {
        int mask=0;
        for(int i=num;i>0;i =i>>1){
            mask=(mask << 1)|1;
        }
        return num^mask;
    }
}