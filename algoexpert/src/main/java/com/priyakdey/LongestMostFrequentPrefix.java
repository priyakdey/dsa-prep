package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestMostFrequentPrefix {

    // NOTE:
    // Build a Trie where each node tracks frequency of visits
    // Use DFS to find the deepest prefix with the highest frequency
    // Return longest among most frequent prefixes; fallback to the longest word if no
    // shared prefix

    public String longestMostFrequentPrefix(String[] words) {
        Trie trie = new Trie();
        int maxLength = 0;
        String longestWord = "";

        for (String word : words) {
            trie.add(word);
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        String prefix = trie.findLongestCommonPrefix();
        if (prefix.isEmpty()) return longestWord;

        return prefix;
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            root = new Node();
        }

        private void add(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.computeIfAbsent(ch, c -> new Node());
                curr = curr.children.get(ch);
                curr.freq++;
            }
        }

        private String findLongestCommonPrefix() {
            // first find if no common prefix at all
            long count = root.children.values().stream()
                    .filter(node -> node.freq > 1).count();
            if (count == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            int maxFreq = 0;
            String prefix = "";

            for (Map.Entry<Character, Node> entry : root.children.entrySet()) {
                char ch = entry.getKey();
                Node node = entry.getValue();
                int freq = dfs(root, node, sb, ch);
                if (freq > maxFreq) {
                    maxFreq = freq;
                    prefix = sb.toString();
                } else if (freq == maxFreq && sb.length() > prefix.length()) {
                    prefix = sb.toString();
                }

                sb.setLength(0);
            }

            return prefix;
        }

        private int dfs(Node parent, Node curr, StringBuilder sb, char ch) {
            if (parent.freq > curr.freq) return parent.freq;

            sb.append(ch);

            int maxFreq = 0;

            for (Map.Entry<Character, Node> entry : curr.children.entrySet()) {
                char _ch = entry.getKey();
                Node node = entry.getValue();
                int freq = dfs(curr, node, sb, _ch);
                maxFreq = Math.max(maxFreq, freq);
            }

            return maxFreq;
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
