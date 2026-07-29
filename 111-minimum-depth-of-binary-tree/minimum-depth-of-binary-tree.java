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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                TreeNode top = queue.poll();
                if(top.left == null && top.right == null) return depth;

                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
            }
    
            depth++;
        }

        return depth;
    }
}