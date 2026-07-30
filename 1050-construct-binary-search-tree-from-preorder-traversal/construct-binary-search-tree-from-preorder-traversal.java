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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, new int[1], Integer.MAX_VALUE);
    }

    public TreeNode constructBST(int[] preorder, int[] i, int max){

        if(i[0] == preorder.length || preorder[i[0]] >= max) return null;

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = constructBST(preorder, i, root.val);
        root.right = constructBST(preorder, i, max);

        return root;

    }
}