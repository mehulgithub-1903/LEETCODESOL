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
    static int camera;
    public int minCameraCover(TreeNode root) {
        
        camera=0;
        if(rec(root)==-1)
        {
            camera++;
            return camera;
        }
        return camera;
    }
    public int rec(TreeNode root)
    {
        if(root==null)
        {
            return 1;
        }
        
        int left=rec(root.left);
        int right=rec(root.right);

        // -1 unmonitored;
        // 1 monitored;
        // 0 has camera
        if(left==-1 || right==-1)
        {
            camera++;
            return 0;
        }
        else if(left!=0 && right!=0)
        {
            return -1;
        }

        return 1;
    }
}