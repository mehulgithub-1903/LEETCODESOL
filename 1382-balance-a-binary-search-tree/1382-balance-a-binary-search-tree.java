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
    private ArrayList<Integer>sortedTraversal;
    public TreeNode balanceBST(TreeNode root) {
     
        sortedTraversal=new ArrayList<Integer>();
        inorderTraversal(root);
        
        int startIndex=0;
        int endIndex=sortedTraversal.size()-1;
        
        TreeNode result=makeBalanceBST(startIndex,endIndex);
        
        return result;
    }
    private void inorderTraversal(TreeNode root)
    {
        if(root==null) return;
        
        inorderTraversal(root.left);
        
        sortedTraversal.add(root.val);
        
        inorderTraversal(root.right);
    }
    private TreeNode makeBalanceBST(int startIndex,int endIndex)
    {
        
        if(startIndex<=endIndex)
        {
            int midIndex=(startIndex+endIndex)/2;
            TreeNode root=new TreeNode();
            root.val=sortedTraversal.get(midIndex);
            root.left=makeBalanceBST(startIndex,midIndex-1);
            root.right=makeBalanceBST(midIndex+1,endIndex);
            
            return root;
        }
        else
        {
            return null;
        }
        
        
    }
}