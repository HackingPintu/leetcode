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
        // List<Integer> list = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // while(true){
        //     if(root != null){
        //         stack.push(root);
        //         root = root.left;
        //     }else{
        //         if(stack.isEmpty()) break;
        //         TreeNode top = stack.pop();
        //         list.add(top.val);
        //         root = top.right;
        //     }
        // } 
        // int l = 0, r = list.size() - 1;
        // while(l < r){
        //     if(list.get(l) + list.get(r) == k) return true;
        //     else if(list.get(l) + list.get(r) > k) r--;
        //     else l++;
        // }
        // return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i + j == k) return true;
            else if(i + j > k) j = r.next();
            else i = l.next();
        }

        return false;
    }
     
    
}
class BSTIterator{
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;
    public BSTIterator(TreeNode root, boolean reverse){
        this.reverse = reverse;
        push(root);
    }

    public void push(TreeNode root){
        if(reverse){
            while(root !=  null){
                stack.push(root);
                root = root.right;
            }
        }else{
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }
    }

    public int next(){
        if(reverse){
            TreeNode top = stack.pop();
            int ans = top.val;
            TreeNode curr = top.left;
            while(curr != null){
                stack.push(curr);
                curr = curr.right;
            }
            return ans;
        }else{
            TreeNode top = stack.pop();
            int ans = top.val;
            TreeNode curr = top.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            return ans;
        }
    }
}