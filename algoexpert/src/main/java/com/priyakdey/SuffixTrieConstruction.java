package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class SuffixTrieConstruction {

    // NOTE: Suffix Trie Construction:
    // Build a Trie where each suffix of the input string is inserted
    // Use a special end symbol * to mark complete suffixes
    // contains(str) returns true only if str is a full suffix (not just a prefix)
    //
    // Time:
    // Build: O(n²) for all suffixes
    // Search: O(m) where m = str.length()
    //
    // Space: O(n²) — stores all substrings as suffix paths

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                TrieNode curr = root;
                for (int j = i; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    curr.children.computeIfAbsent(ch, c -> new TrieNode());
                    curr = curr.children.get(ch);
                }
                curr.children.put('*', null);
            }
        }

        public boolean contains(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                curr = curr.children.get(ch);
                if (curr == null) {
                    return false;
                }
            }

            return curr.children.containsKey('*');
        }
    }

}
