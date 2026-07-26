/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        queue.push(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i< level; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                map.put(top.left, top);
                if(top.right != null) queue.offer(top.right);
                map.put(top.right, top);

            }
        }

        Set<TreeNode> visited = new HashSet<>();

        int dist = 0;
        queue.push(target);
        while(dist < k && !queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                TreeNode top = queue.poll();
                visited.add(top);
                if(top.left != null && !visited.contains(top.left)) queue.offer(top.left);
                if(top.right != null && !visited.contains(top.right)) queue.offer(top.right);
                
                if(map.get(top) != null && !visited.contains(map.get(top)))
                    queue.offer(map.get(top));
            }
            dist++;

        }

        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }

        return list;
    }
}