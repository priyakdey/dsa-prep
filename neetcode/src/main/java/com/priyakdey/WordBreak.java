package com.priyakdey;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class WordBreak {

    // Given a string s and a dictionary of strings wordDict, return true if s can be segmented
    // into a space-separated sequence of dictionary words.
    // You are allowed to reuse words in the dictionary an unlimited number of times.
    // You may assume all dictionary words are unique.

    // Use DFS from index 0, trying all valid prefixes in the word set.
    // Memoize results based on start index to avoid recomputation.

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordsSet = new HashSet<>(wordDict);
        Boolean[][] cache = new Boolean[s.length() + 1][s.length() + 1];
        return wordBreak(s, 0, 0, wordsSet, cache);
    }

    private boolean wordBreak(String s, int start, int index, Set<String> wordDict,
                              Boolean[][] cache) {
        String word = s.substring(start, index);
        if (index == s.length()) {
            return wordDict.contains(word);
        }

        if (cache[start][index] != null) {
            return cache[start][index];
        }

        boolean canBreak = wordBreak(s, start, index + 1, wordDict, cache);

        if (wordDict.contains(word)) {
            canBreak = canBreak || wordBreak(s, index, index + 1, wordDict, cache);
        }

        cache[start][index] = canBreak;
        return canBreak;
    }

}
