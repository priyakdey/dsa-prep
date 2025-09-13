package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class CountNodesWithTheHighestScore {

    // NOTES:
    // Build parent→children adjacency (Map<Integer,List<Integer>>),
    // compute nodeCount[node] = size of subtree by DFS.
    // For each node compute
    // score = (product of sizes of each child subtree) * (n - nodeCount[node] if non-zero);
    // track maxScore and how many nodes reach it.
    //
    // Complexity: O(n) time, O(n) space (tree + subtree array + recursion stack).


    public int countHighestScoreNodes(int[] parents) {
        int length = parents.length;
        Map<Integer, List<Integer>> tree = generateTree(parents);

        int[] nodeCount = new int[length];
        calcNodeCountAt(0, tree, nodeCount);

        long maxScore = 0;
        int count = 0;

        for (int node = 0; node < length; node++) {
            long score = 1;

            if (tree.containsKey(node)) {
                for (int child : tree.get(node)) {
                    score *= nodeCount[child];
                }
            }

            if (node != 0) {
                score *= nodeCount[0] - nodeCount[node];
            }

            if (score > maxScore) {
                maxScore = score;
                count = 1;
            } else if (score == maxScore) {
                count++;
            }
        }

        return count;
    }

    private int calcNodeCountAt(int node, Map<Integer, List<Integer>> tree, int[] nodeCount) {
        if (!tree.containsKey(node)) {
            nodeCount[node] = 1;
            return 1;
        }

        int count = 1;

        for (Integer child : tree.get(node)) {
            count += calcNodeCountAt(child, tree, nodeCount);
        }

        nodeCount[node] = count;
        return count;
    }

    private Map<Integer, List<Integer>> generateTree(int[] parents) {
        int length = parents.length;
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int node = 1; node < length; node++) {
            int parent = parents[node];
            if (!tree.containsKey(parent)) {
                tree.put(parent, new ArrayList<>(2));
            }
            tree.get(parent).add(node);
        }

        return tree;
    }

}
