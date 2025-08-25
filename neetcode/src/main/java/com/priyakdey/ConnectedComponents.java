package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class ConnectedComponents {

    // There is an undirected graph with n nodes. There is also an edges array,
    // where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
    // The nodes are numbered from 0 to n - 1.
    // Return the total number of connected components in that graph.

    // Use BFS on each unvisited node to explore a connected component.
    // Increment count for each new BFS start. Graph is represented with an adjacency matrix.

    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;

            queue.offer(node);
            visited[node] = true;
            connectedComponents++;

            while (!queue.isEmpty()) {
                int _node = queue.poll();

                for (int nbor = 0; nbor < n; nbor++) {
                    if (graph[_node][nbor] == 1 && !visited[nbor]) {
                        queue.offer(nbor);
                        visited[nbor] = true;
                    }
                }

            }
        }

        return connectedComponents;
    }

}
