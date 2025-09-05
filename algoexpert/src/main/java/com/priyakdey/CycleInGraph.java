package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CycleInGraph {

    // NOTE:
    // Cycle in Graph → Detect cycles in a directed graph using DFS with 3-color marking.
    // 0 = unvisited, 1 = visiting and processing neighbours, 2 = fully processed.
    // If during DFS we ever reach a node with state 1, it means we found a back edge → cycle.
    // This method ensures every vertex is checked, and cycles are detected in directed graphs
    // efficiently.

    public boolean cycleInGraph(int[][] edges) {
        int vertices = edges.length;

        // 0 = not visited
        // 1 = currently visiting/processing nbors
        // 2 = processed all nbors
        int[] color = new int[vertices];

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (color[vertex] == 0) {
                if (dfs(edges, vertex, color)) return true;
            }
        }

        return false;
    }


    private boolean dfs(int[][] edges, int vertex, int[] color) {
        if (color[vertex] == 1) return true;

        color[vertex] = 1; // mark it processing

        for (int nbor : edges[vertex]) {
            if (dfs(edges, nbor, color)) {
                return true;
            }
        }

        color[vertex] = 2;  // mark it processed
        return false;
    }

}
