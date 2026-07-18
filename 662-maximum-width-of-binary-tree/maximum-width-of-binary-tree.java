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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<CustomNode> queue = new ArrayDeque<>();
        queue.push(new CustomNode(root, 0));

        int ans = 0;

        while(!queue.isEmpty()){
            int level = queue.size();
            int max = 0, min = 0;

            for(int i = 0; i < level; i++){
                    
                CustomNode top = queue.poll();
                if(i == 0) min = top.index;
                if(i == level-1) max = top.index;
                if(top.node.left != null){
                    queue.offer(new CustomNode(top.node.left, top.index * 2 + 1));
                }
                if(top.node.right != null){
                    queue.offer(new CustomNode(top.node.right, top.index * 2 + 2));
                    
                }
                
            }

            ans = Math.max(ans, max - min + 1);
        
        }

        


        return ans;
    }

    class CustomNode{
        TreeNode node;
        int index;

        public CustomNode(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
}