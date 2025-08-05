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
    public static boolean isMirror(TreeNode tree1,TreeNode tree2){
        if(tree1 == null && tree2==null)return true;
        if(tree1 == null || tree2 == null)return false;
        if(tree1.val != tree2.val) return false;

        return isMirror(tree1.left,tree2.right) && isMirror(tree1.right,tree2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)  return true;
        return isMirror(root.left,root.right);
        
    }
}