package greedy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int profit = 0;
        int curmin = prices[0];

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(prices[i] - curmin, profit);
            curmin = Math.min(prices[i], curmin);
        }

        return profit;
    }

    public static void main(String[] args) {

    }
}
