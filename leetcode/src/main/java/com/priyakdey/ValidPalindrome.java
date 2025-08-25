package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidPalindrome {

    // NOTE :: Two-pointer approach: skip non-alphanumerics,
    // compare using (a ^ 32 == A) trick for ASCII case-insensitivity.
    // Time: O(n), Space: O(1).

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char chLeft  = s.charAt(left);
            char chRight = s.charAt(right);

            boolean skip = false;

            if (!isAlpha(chLeft)) {
                left++;
                skip = true;
            }

            if (!isAlpha(chRight)) {
                right--;
                skip = true;
            }

            if (skip) continue;

            if (!((chLeft == chRight) || ((chLeft ^ 32) == chRight) || (chLeft == (chRight ^ 32)))) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
