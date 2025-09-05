package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TwoColorable {

    // NOTE: Two-Colorable / Bipartite Graph Check
    // Goal: Can we split vertices into 2 sets such that no edge connects same-colored nodes?
    // Algo: Run DFS/BFS. Assign first node a color, give each neighbor the opposite color,
    // recurse/iterate.
    // Key check: If a node already has a color, and it clashes with the required opposite,
    // graph is not bipartite.
    // Complexity: O(V+E) time, O(V) space.
    // Remember: Similar to cycle-check with 3-coloring, but here it’s strict 2-colors
    // and conflict detection.
    // Hint: Odd cycles break bipartiteness; even cycles are fine.

    public boolean twoColorable(int[][] edges) {
        int nodes = edges.length;
        int[] colors = new int[nodes];

        for (int node = 0; node < nodes; node++) {
            if (colors[node] == 0) {
                if (!twoColorable(edges, node, -1, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean twoColorable(int[][] edges, int currNode, int fromNode, int[] colors) {
        if (fromNode != -1 && colors[currNode] != 0) {
            return colors[currNode] == (~colors[fromNode]);
        }

        colors[currNode] = fromNode != -1 ? ~colors[fromNode] : 1;

        for (int edge : edges[currNode]) {
            if (!twoColorable(edges, edge, currNode, colors)) {
                return false;
            }
        }

        return true;
    }

}
