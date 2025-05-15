class Solution {
    public static void dfs(int node,boolean vis[],int[][] isConnected){
        vis[node]=true;
      

        for(int neigh = 0;neigh < isConnected.length;neigh++){
            if(!vis[neigh] && isConnected[node][neigh] == 1){
                dfs(neigh,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int count=0;
        boolean vis[]=new boolean[V+1];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,isConnected);
            }
        }
       
        return count;

        
    }
}