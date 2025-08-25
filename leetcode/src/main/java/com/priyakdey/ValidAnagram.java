package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidAnagram {

    // NOTE: Use a 26-length int[] to count character frequencies from s and subtract while
    // scanning t.
    // Mismatch or negative count → not an anagram.
    // Time: O(n), Space: O(1) (constant for 26 letters).

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freqArr = new int[26];

        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (freqArr[ch - 'a'] == 0) return false;
            freqArr[ch - 'a']--;
        }

        return true;
    }

}
