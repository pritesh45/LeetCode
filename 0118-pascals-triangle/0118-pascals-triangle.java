class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle= new ArrayList<>();

        for(int row=0;row<numRows;row++){

            List<Integer> list=new ArrayList<>();

            for(int j=0;j<=row;j++){
                if(j==0 || j==row){
                    list.add(1);
                }else{
                    int val= triangle.get(row-1).get(j-1)+triangle.get(row-1).get(j);
                    list.add(val);
                }
            }
            triangle.add(list);
        }
        return triangle;
    }
}