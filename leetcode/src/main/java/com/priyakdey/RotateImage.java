package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RotateImage {

    // NOTE: Transpose matrix → swap matrix[i][j] with matrix[j][i]
    // Reverse each row in-place
    //
    // Time: O(n²), Space: O(1) — in-place rotation of n x n matrix.

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix.length;

        for (int row = 0; row < rows; row++) {
            for (int col = row; col < cols; col++) {
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }

        for (int row = 0; row < rows; row++) {
            int left = 0, right = cols - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }

    }

}
