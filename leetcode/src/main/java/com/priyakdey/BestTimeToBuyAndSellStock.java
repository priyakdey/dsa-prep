package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BestTimeToBuyAndSellStock {

    // NOTE: Track the lowest price so far; at each step,
    // calculate profit if sold today. Update max profit accordingly.
    // Time: O(n), Space: O(1).

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];       // Constraint: 1 <= prices.length <= 10^5

        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            if (currPrice > buyPrice) {
                maxProfit = Math.max(maxProfit, currPrice - buyPrice);
            } else {
                buyPrice = currPrice;
            }
        }

        return maxProfit;
    }

}
