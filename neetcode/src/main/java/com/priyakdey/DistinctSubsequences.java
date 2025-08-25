package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class DistinctSubsequences {

    // You are given two strings s and t, both consisting of english letters.
    // Return the number of distinct subsequences of s which are equal to t.

    // Use bottom-up DP to count distinct subsequences of s that match t.
    // Define dp[i][j] as the number of ways to form t[j:] from s[i:].
    // If s[i] == t[j]:
    //         dp[i][j] = dp[i+1][j] + dp[i+1][j+1]
    //         (skip s[i] or match s[i] with t[j])
    // Else:
    //         dp[i][j] = dp[i+1][j]

    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] cache = new int[sLength + 1][tLength + 1];

        for (int j = 0; j < tLength + 1; j++) {
            cache[sLength][j] = 0;
        }

        for (int i = 0; i < sLength + 1; i++) {
            cache[i][tLength] = 1;
        }

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = tLength - 1; j >= 0; j--) {
                cache[i][j] = cache[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    cache[i][j] += cache[i + 1][j + 1];
                }
            }
        }

        return cache[0][0];
    }

}
