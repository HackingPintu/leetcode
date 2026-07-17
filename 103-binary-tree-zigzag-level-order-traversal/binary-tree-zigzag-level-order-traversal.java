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

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftRight = true;
        while(!queue.isEmpty()){

            int level = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < level; i++){
                TreeNode top = queue.poll();
                if(!leftRight) subList.addFirst(top.val);
                else subList.add(top.val);
                if(top.left !=  null) queue.offer(top.left);
                if(top.right !=  null) queue.offer(top.right);   
            }
            leftRight = !leftRight;
            list.add(subList);
        }
        return list;
    }
}