package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GroupAnagrams {

    // Given an array of strings strs, group all anagrams together into sublists. You may return
    // the output in any order.
    // An anagram is a string that contains the exact same characters as another string, but the
    // order of the characters can be different.

    // This solution uses prime hashing to group anagrams in O(n * k) time
    // (where n is number of strings and k is average length of string):
    //      Assign a unique prime number to each lowercase letter 'a' to 'z'.
    //      For each string, compute a hash by multiplying the primes of its characters.
    //      Since anagrams have the same characters (and thus same prime product), their hash
    //      will match.
    //      Store strings in a hashmap using the hash as key and group accordingly

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    private static final int MOD = 1_000_000_007;
    private static final int HASH_INIT = 5381;

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int hash = hashCode(str);
            if (!anagrams.containsKey(hash)) {
                anagrams.put(hash, new ArrayList<>());
            }
            anagrams.get(hash).add(str);
        }

        return anagrams.values().stream().toList();
    }

    private int hashCode(String str) {
        long hash = HASH_INIT;
        for (char ch : str.toCharArray()) {
            hash = ((hash * PRIMES[ch - 'a']) % MOD);
        }

        return (int) hash;
    }

}
