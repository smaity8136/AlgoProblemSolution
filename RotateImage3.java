package com.prep.test.algo.search;

class RotateImage2{
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]



*/

    public static int[][] anticlockWiseRotate(int [][] grid){

        grid =  horizontalFlip(grid);
        return grid = transpose(grid);

    }

    public static int[][] clockWiseRotate(int [][] grid){

        grid =  verticalFlip(grid);
        grid = transpose(grid);
        return grid;
    }

    public static int [][]  horizontalFlip(int [][] grid){

        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row;i++){
            for (int j=0; j<col/2; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[i][col-1-j];
                grid[i][col-1-j]=temp;
            }
        }

        return grid;
    }

    public static int [][] verticalFlip(int [][] grid){

        int row = grid.length;
        int col = grid[0].length;

        for (int i=0;i<row/2;i++){
            int [] temp = grid[i];
            grid[i] = grid[row -1-i];
            grid[row -1-i] = temp;

        }

        return grid;
    }
    public static int[][] transpose(int [][] grid){

        int row = grid.length;
        int col = grid[0].length;

        for(int i=0; i<row;i++){
            for (int j=i; j<col; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i]=temp;
            }
        }
        return grid;
    }

    public static void main (String [] args){

        int [] [] matrix = new int [][]{{1,2,3},
                {4,5,6},
                {7,8,9}};

        int [] [] matrixa = new int [][]{{1,2,3},
                {4,5,6},
                {7,8,9}};

      int[][]  matrixc = clockWiseRotate(matrix);

        printMatrix(matrixc);

        int[][]  matrixac = anticlockWiseRotate(matrixa);

        printMatrix(matrixac);
    }

    private static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row;i++){
            System.out.println();
            for (int j=0; j<col; j++){
                System.out.print(""+matrix[i][j] + "  ");

            }
        }
    }

}
