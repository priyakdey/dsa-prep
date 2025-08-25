package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CoinChangeII {

    // You are given an integer array coins representing coins of different denominations
    // (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.
    // Return the number of distinct combinations that total up to amount.
    // If it's impossible to make up the amount, return 0.

    // Use top-down DP with memoization to count distinct combinations to make amount.
    // At each call, you can:
    //     Include the current coin (stay on same index)
    //     Exclude it (move to next index in the loop)
    //
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[coins.length + 1][amount + 1];
        return change(amount, coins, 0, cache);
    }

    private int change(int amount, int[] coins, int index, Integer[][] cache) {
        if (amount == 0) return 1;
        if (index == coins.length || amount < 0) return 0;

        if (cache[index][amount] != null) return cache[index][amount];

        int count = 0;

        for (int i = index; i < coins.length; i++) {
            count += change(amount - coins[i], coins, i, cache);
        }

        cache[index][amount] = count;
        return count;
    }

}
