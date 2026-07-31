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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(true){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(stack.isEmpty()) break;
                TreeNode top = stack.pop();
                list.add(top.val);
                curr = top.right;
            }
        }
        Collections.sort(list);
        int i = 0;
        curr = root;
        while(true){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(stack.isEmpty()) break;
                TreeNode top = stack.pop();
                top.val = list.get(i++);
                curr = top.right;
            }
        }
        
    }
}