package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestPalindromicString {

    // Given a string s, return the longest substring of s that is a palindrome.
    // A palindrome is a string that reads the same forward and backward.
    // If there are multiple palindromic substrings that have the same length, return any
    // one of them.

    // Use expand-around-center for each index to find longest palindromic substring.
    // Check both odd and even centers.
    // Track max bounds and return s.substring(left, right). Time: O(n²), Space: O(1).

    public String longestPalindrome(String s) {
        int left = -1, right = -1;
        int maxLength = 0;

        int l, r, length;

        for (int i = 0; i < s.length(); i++) {
            // odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            length = (r - 1) - (l + 1) + 1;
            if (length > maxLength) {
                left = l + 1;
                right = r;
                maxLength = length;
            }

            // even length palindrome
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                length = (r - 1) - (l + 1) + 1;
                if (length > maxLength) {
                    left = l + 1;
                    right = r;
                    maxLength = length;
                }
            }
        }

        return s.substring(left, right);
    }

}
