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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Deque<CustomNode> queue = new ArrayDeque<>();
        queue.offer(new CustomNode(root, 0, 0));
        while(!queue.isEmpty()){
            CustomNode top = queue.poll();

            int row = top.row;
            int col = top.col;

            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).offer(top.node.val);

            if(top.node.left != null) queue.offer(new CustomNode(top.node.left, top.row + 1, top.col - 1));
            if(top.node.right != null) queue.offer(new CustomNode(top.node.right, top.row + 1, top.col + 1));

        }

        for(TreeMap<Integer, PriorityQueue<Integer>> sub : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : sub.values()){
                while(!pq.isEmpty()){
                    list.get(list.size() - 1).add(pq.poll());
                }
            }
        }
        return list;
    }
}


class CustomNode{
    TreeNode node;
    int col, row;

    public CustomNode(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}