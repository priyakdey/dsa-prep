package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class InterleavingStrings {

    // You are given three strings s1, s2, and s3. Return true if s3 is formed by interleaving
    // s1 and s2 together or false otherwise.

    // Use recursive DFS to check if s3 is formed by interleaving s1 and s2.
    // At each step k in s3, try matching with s1[i] or s2[j].
    // If either path leads to success, return true.

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleave(String s1, int i, String s2, int j, String s3, int k) {
        if (i == s1.length()) {
            return Objects.equals(s2.substring(j), s3.substring(k));
        }

        if (j == s2.length()) {
            return Objects.equals(s1.substring(i), s3.substring(k));
        }

        boolean canInterleave = false;

        if (s1.charAt(i) == s3.charAt(k)) {
            canInterleave = canInterleave || isInterleave(s1, i + 1, s2, j, s3, k + 1);
        }

        if (s2.charAt(j) == s3.charAt(k)) {
            canInterleave = canInterleave || isInterleave(s1, i, s2, j + 1, s3, k + 1);
        }

        return canInterleave;
    }

}
