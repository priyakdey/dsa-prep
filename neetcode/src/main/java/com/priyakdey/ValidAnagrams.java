package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ValidAnagrams {

    // Given two strings s and t, return true if the two strings are anagrams of each other,
    // otherwise return false.
    // An anagram is a string that contains the exact same characters as another string,
    // but the order of the characters can be different.

    // Use a HashMap to count character frequencies in s.
    // Then iterate through t, decrementing counts.
    // If a char in t doesn’t exist in the map or count mismatches, return false.
    // Finally, the map should be empty if the strings are true anagrams.

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counter.compute(ch, (_, v) -> v == null ? 1 : v + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!counter.containsKey(ch)) {
                return false;
            }
            counter.computeIfPresent(ch, (_, v) -> v == 1 ? null : v - 1);
        }

        return counter.isEmpty();
    }

}
