class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            if(stack.peek()=='(' && arr[i]==')') stack.pop();
            else if(stack.peek()=='[' && arr[i]==']') stack.pop();
            else if(stack.peek()=='{' && arr[i]=='}') stack.pop();
            else stack.push(arr[i]);
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}