/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
int height(TreeNode* root,int &diameter){
    if(root==NULL){
        return 0;
    }
    int Hleft=height(root->left,diameter);
    int Hright=height(root->right,diameter);

    diameter=max(diameter,Hleft+Hright);
    return 1+max(Hleft,Hright);

}
    int diameterOfBinaryTree(TreeNode* root) {
        int diameter=0;

        height(root,diameter);
        return diameter;
    }
};