/*
BUY AND SELL STOCK 
    -> buy should be done before selling
    -> and remember that the transaction occurs only once
    -> if you are selling on ith day
    -> you buy on the minimum price from 1st to (i-1)
    -> 
    -> TC: O(n)
    -> SC: O(1)
 */

public class buy_sell_stock {
    public static int maximize_profit(int prices[]){
        int min_i=prices[0];
        int maxProfit=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            int cost=prices[i]-min_i; //min_i => buy
            maxProfit=Math.max(maxProfit,cost);
            min_i=Math.min(min_i,prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int a[]={7,1,5,3,6,4};
        System.out.println("Maximum Profit: "+maximize_profit(a));
    }
}
