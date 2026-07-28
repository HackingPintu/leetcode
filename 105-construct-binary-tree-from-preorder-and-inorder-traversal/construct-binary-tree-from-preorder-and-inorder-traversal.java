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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : inorder){
            map.put(num, i++);
        }

        return builder(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder, map);
    }

    public TreeNode builder(int preStart, int preEnd, int[] pre, int inStart, int inEnd, int[] in, Map<Integer, Integer> map){

        if(inStart > inEnd || preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);

        int inRoot = map.get(pre[preStart]);

        int numsLeft = inRoot - inStart;

        root.left = builder(preStart + 1, preStart + numsLeft, pre, inStart, inRoot - 1, in, map);

        root.right = builder(preStart + numsLeft + 1, preEnd, pre, inRoot + 1, inEnd, in, map); 

        return root;
    }
}