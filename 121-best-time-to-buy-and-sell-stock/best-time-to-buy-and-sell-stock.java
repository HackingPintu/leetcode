class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int max = 0;
        int currPrice = prices[0];
        for(int i = 1; i < n; i++){
            int price = prices[i];
            if(price < currPrice){
                currPrice = price;
            }else{
                max = Math.max(max, price - currPrice);
            }        
        } 
        return max;
    }
}