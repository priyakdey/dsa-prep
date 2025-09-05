package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ShortestUniquePrefixes {

    // NOTE:
    // Build Trie → freq count at each node.
    // Insert all words → increment freq per node.
    // Unique prefix = first path where freq == 1.
    // Stop traversal once freq=1 or word iteration is over → that prefix is answer.

    public String[] shortestUniquePrefixes(String[] words) {
        int length = words.length;
        String[] prefixes = new String[length];

        Trie trie = new Trie();
        trie.addAll(words);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String word = words[i];
            trie.findUniquePrefix(word, sb);
            prefixes[i] = sb.toString();
            sb.setLength(0);
        }

        return prefixes;
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            root = new Node();
        }

        private void findUniquePrefix(String word, StringBuilder sb) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                curr = curr.children.get(ch);
                sb.append(ch);
                if (curr.freq == 1) break;
            }
        }

        private void addAll(String[] words) {
            for (String word : words) {
                add(word);
            }
        }

        private void add(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.computeIfAbsent(ch, k -> new Node());
                curr = curr.children.get(ch);
                curr.freq++;
            }
        }

    }

    private static class Node {
        private final Map<Character, Node> children;
        private int freq;

        private Node() {
            children = new HashMap<>();
        }
    }

}
