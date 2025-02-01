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
    static int height(int[] diameter,TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(diameter,root.left);
        int rh=height(diameter,root.right);
        diameter[0]=Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter =new int[1];
        height(diameter,root);
        return diameter[0];
        
    }
}