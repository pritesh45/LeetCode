class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int price:prices){
            if(price<minPrice){
                minPrice=price;
            }
            else{
                int Profit=price-minPrice;
                if(Profit>maxProfit){
                    maxProfit=Profit;
                }
            }
        }
        return maxProfit;
    }
}