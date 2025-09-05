package com.priyakdey;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LargestIsland {

    // NOTE: use a DSU for this
    // Largest Island → Label each land component with unique id, store sizes in map.
    // For every water cell, check 4 neighbors, sum distinct component sizes +1 (flip).
    // Use a Set to avoid double-counting, track max size.
    // Edge cases: all water → 1, all land → full grid.
    // Time/space: O(R·C) optimal.

    public int largestIsland(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        DSU dsu = new DSU(matrix);
        int maxSize = 0;


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    maxSize = Math.max(maxSize, dsu.visit(row, col));
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    maxSize = Math.max(maxSize, dsu.ifMerged(row, col));
                }
            }
        }

        return maxSize;
    }

    private class DSU {
        private final int rows;
        private final int cols;

        private final int[][] matrix;

        private final Map<Integer, Integer> roots = new HashMap<>();

        private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private int counter = 2;

        DSU(int[][] matrix) {
            this.rows = matrix.length;
            this.cols = matrix[0].length;
            this.matrix = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                System.arraycopy(matrix[row], 0, this.matrix[row], 0, cols);
            }
        }

        int visit(int row, int col) {
            int size = _visit(row, col);
            if (size == 0) return size;
            roots.put(counter, size);
            counter++;
            return size;
        }

        int _visit(int row, int col) {
            if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != 0) {
                return 0;
            }

            int size = 1;

            matrix[row][col] = counter;
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                size += _visit(nextRow, nextCol);
            }

            return size;
        }


        /**
         * This method does not actually merge the sets, it answers the question:
         * what is the size of the island if given row col is a land and merges with
         * neighbouring land if possible.
         *
         * @param row int
         * @param col int
         * @return size of the island if (row, col) is converted to a land
         */
        int ifMerged(int row, int col) {
            int size = 1;
            Set<Integer> seen = new HashSet<>();

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols
                        || matrix[nextRow][nextCol] == 1) {
                    continue;
                }

                int root = matrix[nextRow][nextCol];
                if (!seen.contains(root)) {
                    size += roots.get(root);
                    seen.add(root);
                }
            }

            return size;
        }

    }

}
