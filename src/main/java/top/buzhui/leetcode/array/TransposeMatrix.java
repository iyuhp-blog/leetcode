package top.buzhui.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/transpose-matrix">转置矩阵</a>
 *
 * @author iyuhp created at 2020/10/16
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}})));
        System.out.println(Arrays.deepToString(transpose(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}})));
    }

    private static int[][] transpose(int[][] matrix) {
        // 行
        int rows = matrix.length;
        // 列
        int columns = matrix[0].length;

        int[][] newMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
