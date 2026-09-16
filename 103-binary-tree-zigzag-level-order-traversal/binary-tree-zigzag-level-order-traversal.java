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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
                list.add(top.val);
            }

            if (!leftToRight){
                Collections.reverse(list);
                
            }
            leftToRight = !leftToRight;
            res.add(list);


        }

        return res;
       
    }
}