package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class GraphValidTree {

    // Given n nodes labeled from 0 to n - 1 and a list of undirected edges
    // (each edge is a pair of nodes), write a function to check whether these edges make
    // up a valid tree.

    public boolean validTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(graph[row][col]);
                if (col < n - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;

            visited.add(i);
            if (!traverse(i, -1, graph, visited)) return false;
        }

        return visited.size() == n;
    }

    private boolean traverse(int node, int parent, int[][] graph, Set<Integer> visited) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (int i = 0; i < graph[node].length; i++) {
            if (i != parent && graph[node][i] == 1) {
                if (!traverse(i, node, graph, visited)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        System.out.println(graphValidTree.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        System.out.println(graphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }

}
