package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RemoveIslands {

    // NOTE: Remove Islands → Use DFS from border 1s to mark connected land as safe.
    // After marking, convert safe cells back to 1 and flip all remaining 1s (enclosed islands) to 0.
    // Effectively removes islands not touching the border.

    public int[][] removeIslands(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int col = 0; col < cols; col++) {
            // first row
            if (matrix[0][col] == 1) {
                markVisited(matrix, new Cell(0, col), rows, cols, directions);
            }

            // last row
            if (matrix[rows - 1][col] == 1) {
                markVisited(matrix, new Cell(rows - 1, col), rows, cols, directions);
            }
        }

        for (int row = 0; row < rows; row++) {
            // first col
            if (matrix[row][0] == 1) {
                markVisited(matrix, new Cell(row, 0), rows, cols, directions);
            }

            // last col
            if (matrix[row][cols - 1] == 1) {
                markVisited(matrix, new Cell(row, cols - 1), rows, cols, directions);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                } else if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void markVisited(int[][] matrix, Cell cell, int rows, int cols, int[][] directions) {
        if (!cell.inRange(rows, cols) || matrix[cell.row][cell.col] != 1) return;

        int row = cell.row, col = cell.col;
        matrix[row][col] = 2;       // mark the cell visited

        for (int[] direction : directions) {
            Cell nextCell = cell.nextCell(direction);
            markVisited(matrix, nextCell, rows, cols, directions);
        }
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
