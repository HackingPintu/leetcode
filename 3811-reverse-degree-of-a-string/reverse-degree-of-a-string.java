class Solution {
    public int reverseDegree(String s) {
        int i = 1;
        int sum = 0;
        for(char ch : s.toCharArray()){
            sum += (('z' - ch + 1) * i++);
        }

        return sum;
    }
}