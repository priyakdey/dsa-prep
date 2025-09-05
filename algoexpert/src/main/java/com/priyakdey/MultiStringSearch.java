package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class MultiStringSearch {

    // NOTE: Build a suffix trie from bigString by inserting all suffixes starting at each index
    // For each smallString, check presence via standard trie search

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie();
        int length = bigString.length();

        for (int i = 0; i < length; i++) {
            trie.add(bigString, i);
        }

        List<Boolean> isWordPresent = new ArrayList<>(smallStrings.length);
        for (String word : smallStrings) {
            isWordPresent.add(trie.isPresent(word));
        }

        return isWordPresent;
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            this.root = new Node();
        }

        private void add(String word, int from) {
            Node curr = root;
            for (int i = from; i < word.length(); i++) {
                char ch = word.charAt(i);
                curr.children.computeIfAbsent(ch, c -> new Node());
                curr = curr.children.get(ch);
            }
        }

        private boolean isPresent(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) return false;
                curr = curr.children.get(ch);
            }

            return true;
        }

    }

    private static class Node {
        private final Map<Character, Node> children;

        private Node() {
            children = new HashMap<>();
        }
    }

}
