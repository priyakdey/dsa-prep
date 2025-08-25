package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class TopologicalSort {

    // Implement topological sort.
    // Topological sort is an algorithm for linearly ordering the vertices of a directed acyclic
    // graph such that for every directed edge
    //  (u,v), vertex
    //      u comes before
    //      v in the ordering.
    //
    // Given a directed graph, perform a topological sort on its vertices and return the order
    // as a list of vertex labels. There may be multiple valid topological sorts for a given graph,
    // so you may return any valid ordering.
    // If the graph contains a cycle, you should return an empty list to indicate that a
    // topological sort is not possible.
    //
    // Input:
    //      n - the number of vertices in the graph. Each vertex is labeled from 0 to n - 1.
    //      edges - a list of pairs, each representing a directed edge in the form (u, v),
    //              where u is the source vertex and v is the destination vertex.

    // Topological sort
    // 1. Generate the graph (adj matrix)
    // 2. Generate the indegrees array - number of incoming edges for the node
    // 3. Push all nodes with indegree zero in the queue (nodes with no incoming edges can be used to start the entry into the graph)
    // 4. Iterate over the neighbours of the polled nodes, and if indegree becomes zero, queue them.

    public List<Integer> topologicalSort(int n, int[][] edges) {
        int[][] matrix = new int[n][n];

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            matrix[src][dest] = 1;
        }

        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    indegrees[j]++;
                }
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>(n);

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            order.add(idx);
            indegrees[idx]--;

            for (int i = 0; i < n; i++) {
                if (matrix[idx][i] == 1) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return order.size() == n ? order : new ArrayList<>(0);
    }

}
