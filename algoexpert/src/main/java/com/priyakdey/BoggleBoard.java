package com.priyakdey;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class BoggleBoard {

    // NOTES:
    // Build a Trie of all words → enables prefix pruning (skip dead paths fast).
    // Run DFS from every cell → explore 8 directions, mark visited ('\0'), restore after backtrack.
    // Each step: check Trie child for current char; if null → prune, else continue.
    // If Trie node marks isWord, add to result set (avoid duplicates).
    // Final answer = all words in board found via DFS + Trie.
    // Time: O(rows * cols * 8^k) worst-case, but Trie pruning drastically cuts search.

    public static List<String> boggleBoard(char[][] board, String[] words) {
        int rows = board.length, cols = board[0].length;

        Trie trie = new Trie();
        trie.addAll(words);

        Set<String> acc = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, row, col, rows, cols, trie.root, acc);
            }
        }

        return new ArrayList<>(acc);
    }

    private static void dfs(char[][] board, int row, int col, int rows, int cols,
                            Node node, Set<String> acc) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == '\0') {
            return;
        }

        char ch = board[row][col];
        Node next = node.children[ch];
        if (next == null) return;

        if (next.isWord) {
            acc.add(next.word);
        }


        board[row][col] = '\0';

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                dfs(board, row + dr, col + dc, rows, cols, next, acc);
            }
        }

        board[row][col] = ch;
    }

    private static class Trie {
        private final Node root;

        Trie() {
            root = new Node();
        }

        void addAll(String[] words) {
            for (String word : words) {
                this.add(word);
            }
        }

        void add(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch] == null) {
                    curr.children[ch] = new Node();
                }
                curr = curr.children[ch];
            }

            curr.isWord = true;
            curr.word = word;
        }
    }

    private static class Node {
        Node[] children;
        String word;
        boolean isWord;

        Node() {
            this.children = new Node[256];      // NOTE: does not work with utf8
            this.word = null;
            this.isWord = false;
        }

    }

}
