class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit =0;
       int minprice= Integer.MAX_VALUE ;
       for(int nums : prices){
            if(nums < minprice){
                minprice = nums ;
            }
            int profit = nums- minprice;
            if(profit > maxProfit ){
                maxProfit = profit;
            }
       }
       return maxProfit;
    }
}