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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightView(root, 0);
        return list;
    }

    public void rightView(TreeNode root,int level){

        if(root == null) return;

        if(level == list.size()) list.add(root.val);

        rightView(root.right, level+1);
        rightView(root.left, level+1);

    }
}