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
    public static void fun(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        fun(root.left,list);
        fun(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        fun(root,list);
        return list;
    }
}