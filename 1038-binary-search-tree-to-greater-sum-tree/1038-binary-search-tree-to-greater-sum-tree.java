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
    int ts;
    public TreeNode bstToGst(TreeNode root) {
        
        ts=0;
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root)
    {
        if(root==null) return;
        
        dfs(root.right);
        root.val+=ts;
        ts=root.val;
        dfs(root.left);
        
    }
    
}