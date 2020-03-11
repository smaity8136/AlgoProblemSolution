package com.leetcode.amazone.test;

public class RotateImage2 {

    //swap approach

    /*public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

        return matrix;
    }*/

    public static int[][] rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return null;

        // length of the matrix
        int n = matrix.length;

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // swap elements for each row
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int [] [] matrix = new int [][]{{1,2,3},
                                        {4,5,6},
                                        {7,8,9}};

        matrix = rotate(matrix);

        System.out.println(""+matrix);

    }
}
