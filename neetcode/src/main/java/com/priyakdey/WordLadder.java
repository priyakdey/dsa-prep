package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class WordLadder {

    // You are given two words, beginWord and endWord, and also a list of words wordList.
    // All of the given words are of the same length, consisting of lowercase English letters,
    // and are all distinct.
    // Your goal is to transform beginWord into endWord by following the rules:
    //  - You may transform beginWord to any word within wordList, provided that at exactly one
    //    position the words have a different character, and the rest of the positions have the
    //    same characters.
    //  - You may repeat the previous step with the new word that you obtain, and you may do this
    //    as many times as needed.
    // Return the minimum number of words within the transformation sequence needed to obtain the
    // endWord, or 0 if no such sequence exists.

    // Reverse BFS from endWord toward beginWord, stopping when you reach a word 1 edit
    // away from beginWord.
    // Precompute these 1-edit neighbors and use a BFS over the wordList graph.
    // Elegant optimization!

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (Objects.equals(beginWord, endWord)) {
            return 0;
        }

        Set<String> closestWords = findClosestWords(beginWord, wordList);
        Map<String, List<String>> graph = generateGraph(wordList);

        if (!graph.containsKey(endWord)) return 0;


        Deque<Pair> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair(endWord, 1));
        visited.add(endWord);

        int minDistance = Integer.MAX_VALUE;    // words since max number of words are 100

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (closestWords.contains(pair.word)) {
                minDistance = Math.min(minDistance, pair.distance);
                continue;
            }

            for (String nextWord : graph.get(pair.word)) {
                if (!visited.contains(nextWord)) {
                    queue.offer(new Pair(nextWord, pair.distance + 1));
                    visited.add(nextWord);
                }
            }
        }

        return minDistance != Integer.MAX_VALUE ? minDistance + 1 : 0;
    }

    private Map<String, List<String>> generateGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String word : wordList) {
            graph.put(word, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            String src = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String dest = wordList.get(j);
                if (calcDistance(src, dest) == 1) {
                    graph.get(src).add(dest);
                    graph.get(dest).add(src);
                }
            }
        }

        return graph;
    }

    private Set<String> findClosestWords(String beginWord, List<String> wordList) {
        Set<String> closestWords = new HashSet<>();

        for (String word : wordList) {
            if (calcDistance(beginWord, word) == 1) {
                closestWords.add(word);
            }
        }

        return closestWords;
    }

    private int calcDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

    private record Pair(String word, int distance) {
    }

}
