package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinimumPassesOfMatrix {

    // NOTE: This is same as Rotten Oranges problem
    // Minimum Passes of Matrix → Treat positives as BFS sources and convert adjacent negatives
    // level by level (one pass = one BFS layer).
    // Track the number of passes required until all negatives turn positive.
    // If any negative remains unreachable, return -1.

    public int minimumPassesOfMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        Deque<Cell> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int minPasses = 0;
        int negativeCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] > 0) {
                    queue.offer(new Cell(row, col, 0));
                    visited[row][col] = true;
                } else if (matrix[row][col] < 0) {
                    negativeCount++;
                } else {
                    visited[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            minPasses = Math.max(minPasses, cell.pass);

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);
                if (nextCell.inRange(rows, cols) && !visited[nextCell.row][nextCell.col]
                        && matrix[nextCell.row][nextCell.col] < 0) {
                    queue.offer(nextCell);
                    visited[nextCell.row][nextCell.col] = true;
                    negativeCount--;
                }
            }
        }

        return negativeCount == 0 ? minPasses : -1;
    }

    private record Cell(int row, int col, int pass) {
        Cell nextCell(int[] direction) {
            return new Cell(row + direction[0], col + direction[1], pass + 1);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }

}
