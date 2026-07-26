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
    public int amountOfTime(TreeNode root, int start) {

        if(root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode target = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            if(top.val == start) target = top;
            if(top.left != null) {
                queue.offer(top.left);
                map.put(top.left, top);
            }
            if(top.right != null) {
                queue.offer(top.right);
                map.put(top.right, top);
            }
        }
        queue.push(target);
        int time = 0;
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                TreeNode top = queue.poll();
                visited.add(top);
                if(top.left !=null && !visited.contains(top.left)) queue.offer(top.left);
                if(top.right !=null && !visited.contains(top.right)) queue.offer(top.right);
                if(map.get(top) != null && !visited.contains(map.get(top))) queue.offer(map.get(top));
            }
            time++;
        }
        return time - 1;
    }
}