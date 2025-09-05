package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class RiverSizes {

    // NOTE: River Sizes → BFS flood fill to count connected 1s, mark visited,
    // and collect river lengths.

    public static List<Integer> riverSizes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> riverSizes = new ArrayList<>();

        Deque<Cell> queue = new ArrayDeque<>();

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != 1) continue;

                queue.offer(new Cell(row, col));
                matrix[row][col] = 2;       // visited
                int riverSize = 0;

                while (!queue.isEmpty()) {
                    Cell cell = queue.poll();
                    riverSize++;

                    for (int[] direction : directions) {
                        Cell nextCell = cell.nextCell(direction);
                        if (nextCell.inRange(rows, cols) && matrix[nextCell.row][nextCell.col] == 1) {
                            queue.offer(nextCell);
                            matrix[nextCell.row][nextCell.col] = 2;
                        }
                    }
                }

                riverSizes.add(riverSize);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 2) {
                    matrix[row][col] = 1;       // revert the visited flag
                }
            }
        }

        return riverSizes;
    }

    private record Cell(int row, int col) {

        Cell nextCell(int[] direction) {
            return new Cell(row + direction[0], col + direction[1]);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

    }

}
