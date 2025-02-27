class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] newmat=new int[r][c];
        Queue<Integer> queue=new LinkedList<>();
         if((m*n)!=(r*c)){
            return mat;
         }
        if((m*n)==(r*c)){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    queue.add(mat[i][j]);
                }
            }

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    newmat[i][j]=queue.poll();
                }
            }
        }
        return newmat;
        
    }
}