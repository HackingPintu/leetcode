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
    public boolean isBalanced(TreeNode root) {
        
        return findHeight(root) != -1;
    }


    public int findHeight(TreeNode root){
        if(root == null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        if(lh == -1 || rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);

        
    }
}