package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ClimbingStairs {

    // You are given an integer n representing the number of steps to reach the top of a staircase.
    // You can climb with either 1 or 2 steps at a time.
    // Return the number of distinct ways to climb to the top of the staircase.

    // Use top-down DP with memoization:
    // Number of ways to reach step n = ways to reach n-1 + n-2.
    // Base cases: f(0)=1, f(n<0)=0.
    // Memoize results in cache[n] to avoid recomputation.
    // This is fib sequence

    public int climbStairs(int n) {
        Integer[] cache = new Integer[n + 1];
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, Integer[] cache) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (cache[n] != null) return cache[n];

        cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        return cache[n];
    }

}
