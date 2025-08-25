package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PalindromicSubstrings {

    // Given a string s, return the number of substrings within s that are palindromes.
    // A palindrome is a string that reads the same forward and backward.

    // Use expand-around-center to count all palindromic substrings.
    // For each index i, expand for:
    //      Odd-length palindromes centered at i
    //      Even-length palindromes centered between i and i+1
    // Increment count on each valid expansion.

    public int countSubstrings(String s) {
        int count = 0;
        int l, r;

        for (int i = 0; i < s.length(); i++) {
            count++;

            // odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }

            // even length palindrome
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                }
            }
        }

        return count;
    }

}
