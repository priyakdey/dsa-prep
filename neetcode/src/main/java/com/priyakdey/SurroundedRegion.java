package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class SurroundedRegion {

    // You are given a 2-D matrix board containing 'X' and 'O' characters.
    // If a continuous, four-directionally connected group of 'O's is surrounded by 'X's, it is
    // considered to be surrounded.
    // Change all surrounded regions of 'O's to 'X's and do so in-place by modifying the input
    // board.

    // Use BFS from border 'O's, marking all connected 'O's as temporary 'Y' to protect them.
    // After BFS, convert remaining 'O's to 'X' (surrounded), and revert 'Y' back to 'O'.
    // In-place transformation.

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Deque<Cell> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                queue.offer(new Cell(row, 0));
                board[row][0] = 'Y';
            }
            if (board[row][cols - 1] == 'O') {
                queue.offer(new Cell(row, cols - 1));
                board[row][cols - 1] = 'Y';
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                queue.offer(new Cell(0, col));
                board[0][col] = 'Y';
            }
            if (board[rows - 1][col] == 'O') {
                queue.offer(new Cell(rows - 1, col));
                board[rows - 1][col] = 'Y';
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Cell cell = queue.pop();

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);

                if (nextCell.inRange(rows, cols) && board[nextCell.row][nextCell.col] == 'O') {
                    queue.offer(nextCell);
                    board[nextCell.row][nextCell.col] = 'Y';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                } else {
                    board[row][col] = 'X';
                }
            }
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
