/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root==null ||  root==p || root==q)
      {
          return root;
      }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
//         find anyone or both node in left or return left as null;
       
//         find any or both node in right or return right as null;
        
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left==null) return right;
        if(right==null) return left;
        
//         if both are not null we means one node is present in right sub and one is present in left subtree
        
        return root;
    }
}