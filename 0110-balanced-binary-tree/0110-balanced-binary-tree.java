/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int dfsH(TreeNode root){
        if(root == null){
            return 0;

        }
        int lh=dfsH(root.left);
        if(lh== -1){
            return -1;
        }
        int rh=dfsH(root.right);
        if(rh== -1){
            return -1;
        }
        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        return dfsH(root)!= -1;
        
    }
}