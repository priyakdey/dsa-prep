package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CoinChange {

    // You are given an integer array coins representing coins of different denominations
    // (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.
    // Return the fewest number of coins that you need to make up the exact target amount.
    // If it is impossible to make up the amount, return -1.
    // You may assume that you have an unlimited number of each coin.

    // Use top-down DP with memoization to minimize the number of coins.
    // At each state (index, amount), try all coin choices from current index onward.
    // Recursive relation:
    //      If amount == 0: return 0
    //      If amount < 0 or index == coins.length: return ∞ (invalid)
    //      Else: dp[index][amount] = min(1 + dp[index][amount - coin]) for all coins[i]
    //
    // Memoize with dp[index][amount] to avoid recomputation.

    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length + 1][amount + 1];
        int count = coinChange(coins, 0, amount, cache);
        return count != Integer.MAX_VALUE ? count : -1;
    }

    private int coinChange(int[] coins, int index, int amount, Integer[][] cache) {
        if (amount == 0) return 0;
        if (index == coins.length || amount < 0) return Integer.MAX_VALUE;

        if (cache[index][amount] != null) return cache[index][amount];

        int count = Integer.MAX_VALUE;
        for (int i = index; i < coins.length; i++) {
            int _count = coinChange(coins, i, amount - coins[i], cache);
            if (_count != Integer.MAX_VALUE) {
                count = Math.min(count, 1 + _count);
            }
        }

        cache[index][amount] = count;
        return count;
    }
}
