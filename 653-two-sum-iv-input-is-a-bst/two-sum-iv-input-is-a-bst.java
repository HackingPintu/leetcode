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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty()) break;
                TreeNode top = stack.pop();
                list.add(top.val);
                root = top.right;
            }
        } 
        int l = 0, r = list.size() - 1;
        while(l < r){
            if(list.get(l) + list.get(r) == k) return true;
            else if(list.get(l) + list.get(r) > k) r--;
            else l++;
        }
        return false;
    }
}