package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PalindromicSubstrings {

    // Expand around each center (odd & even). For every match, increment count.
    // Time: O(n²), Space: O(1) — brute-force optimized via center expansion.

    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        int l, r;

        for (int i = 0; i < length; i++) {
            // generate odd length palindrome
            count++;
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }

            // check for even length palindrome
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                }
            }
        }

        return count;
    }

}
