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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : inorder){
            map.put(num, i++);
        }

        return builder(0, postorder.length - 1, postorder, 0, inorder.length - 1, inorder, map);
    }

    public TreeNode builder(int postStart, int postEnd, int[] post, int inStart, int inEnd, int[] in, Map<Integer, Integer> map){

        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(post[postEnd]);

        int inRoot = map.get(post[postEnd]);

        int numsLeft = inRoot - inStart;

        root.left = builder(postStart, postStart + numsLeft - 1, post, inStart, inRoot - 1, in, map);

        root.right = builder(postStart + numsLeft, postEnd - 1, post, inRoot + 1, inEnd, in, map); 

        return root;
    }
}