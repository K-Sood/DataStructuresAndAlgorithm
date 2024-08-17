package main.java.dynammicProgramming;

/**
 * Problem link : https://www.naukri.com/code360/problems/minimum-path-sum_985349?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
 */

public class MinSumPath {

    public static int minSumPath(int[][] grid) {
        // return minSumPathRecursive(grid.length-1, grid[0].length-1, grid);
        int[][] dp = new int[grid.length][grid[0].length];


        // return minSumPathMemoized(grid.length-1, grid[0].length-1, grid, dp);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(i ==0 && j==0){
                    dp[0][0] = grid[0][0];
                }else {
                    int upSum = Integer.MAX_VALUE;
                    int leftSum = Integer.MAX_VALUE;

                    if(i>0)
                        upSum = dp[i-1][j] + grid[i][j];
                    if(j>0)
                        leftSum = dp[i][j-1] + grid[i][j];


                    dp[i][j] = Math.min(upSum, leftSum);
                }

            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    private static int minSumPathMemoized(int i, int j, int[][] grid, int[][] dp){

        if(i==0 && j==0){
            return dp[0][0] = grid[0][0];
        }
        if(i<0 || j<0){
            return (int)Math.pow(10, 9);
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }


        int leftPathSum = minSumPathMemoized(i, j-1, grid, dp)+ grid[i][j];
        int topPathSum = minSumPathMemoized(i-1, j, grid, dp)+ grid[i][j];

        return dp[i][j] = Math.min(leftPathSum, topPathSum);



    }

    private static int minSumPathRecursive(int i, int j, int[][] grid){

        if(i ==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return (int)Math.pow(10, 9);
        }


        int leftPathSum = minSumPathRecursive(i, j-1, grid)+ grid[i][j];
        int topPathSum = minSumPathRecursive(i-1, j, grid)+ grid[i][j];

        return Math.min(leftPathSum, topPathSum);
    }
}
