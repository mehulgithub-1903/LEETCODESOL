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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        int level=0;
        int ansLevel=0;
        int maxSum=Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            int s=q.size();
            level++;
            int ts=0;
            
            for(int i=0;i<s;i++)
            {
                TreeNode x=q.poll();
                ts+=x.val;
                if(x.left!=null) q.add(x.left);
               if(x.right!=null) q.add(x.right);
                
            }
            
            if(ts>maxSum)
            {
                ansLevel=level;
                maxSum=ts;
            }
        }
        
        
        return ansLevel;
    }
}