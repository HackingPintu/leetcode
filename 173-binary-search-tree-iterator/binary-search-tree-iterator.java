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
class BSTIterator {
    List<Integer> list;
    int curr = 0;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
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
    }
    
    public int next() {
        return list.get(curr++);
    }
    
    public boolean hasNext() {
        return curr < list.size(); 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */