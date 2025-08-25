package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestPalindromeSubstring {

    // NOTE: Expand around each center (odd & even) to find the longest palindrome.
    // Track max length and return substring.
    // Time: O(n²), Space: O(1).

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;

        int maxLength = 0;
        int left = 0, right = 0;

        int l, r;
        int len;

        for (int i = 0; i < length; i++) {
            // generate odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            len = (r - 1) - (l + 1) + 1;
            if (len > maxLength) {
                maxLength = len;
                left = l + 1;
                right = r;
            }

            // check for even length palindrome
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                len = (r - 1) - (l + 1) + 1;
                if (len > maxLength) {
                    maxLength = len;
                    left = l + 1;
                    right = r;
                }
            }
        }

        return s.substring(left, right);
    }

}
