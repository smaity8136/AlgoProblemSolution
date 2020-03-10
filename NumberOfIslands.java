package com.leetcode.amazone.test;

public class NumberOfIslands {

    /*
    * Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands.
    * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    * You may assume all four edges of the grid are all surrounded by water.
    * Example
    * Input
    * 11110
    * 11010
    * 11000
    * 00000
    * Answer: 1
    *
    * */


    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfsCleanSurroundings(grid,i,j);
                }

            }

        }

      return count;
    }

    public static void dfsCleanSurroundings(char[][] grid, int i, int j){

        if (i<0|| j<0 || i>= grid.length || j>= grid[0].length|| grid[i][j] == '0') return;

        grid[i][j]='0';

        dfsCleanSurroundings(grid,i+1,j);
        dfsCleanSurroundings(grid,i-1,j);
        dfsCleanSurroundings(grid,i,j+1);
        dfsCleanSurroundings(grid,i,j-1);


    }

    public static void main(String[] args) {

        char [] [] grid = new char [][]{{'1','1','1','1','0'},
                                        {'1','1','0','1','0'},
                                        {'1','1','0','0','0'},
                                        {'0','0','0','1','1'}
                                        };



        int num = numIslands(grid);

        System.out.println("num of islands : "+num);
    }

}
