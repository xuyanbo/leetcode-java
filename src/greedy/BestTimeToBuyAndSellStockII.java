package greedy;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i-1] < prices[i]) {
                profit += (prices[i] - prices[i-1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(nums));
    }
}
