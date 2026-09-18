class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        if (k == cardPoints.length) return sum;
        max = Math.max(max, sum);
        int n = cardPoints.length - 1;
        while (k > 0){
            sum -= cardPoints[--k];
            sum += cardPoints[n--];
            max = Math.max(sum, max); 
        }

        return max;
    }
}