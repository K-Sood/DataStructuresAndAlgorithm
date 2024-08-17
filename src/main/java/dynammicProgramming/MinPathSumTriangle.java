package main.java.dynammicProgramming;

import java.util.Arrays;

/**
 * Question link : https://www.naukri.com/code360/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
 */

public class MinPathSumTriangle {
    public static int minimumPathSum(int[][] triangle, int n) {
        // return minimumPathSumRecursive(triangle, 0,0);
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        // return minimumPathSumMemoised(triangle, 0, 0, dp);

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(i == n-1){
                    dp[i][j] = triangle[i][j];
                }else{
                    int diagonalDownSum = triangle[i][j] + dp[i+1][j+1];
                    int downSum = triangle[i][j] + dp[i+1][j];

                    dp[i][j] = Math.min(diagonalDownSum, downSum);
                }


            }
        }
        return dp[0][0];

    }

    private static int minimumPathSumMemoised(int[][] triangle, int i, int j, int[][] dp){

        if(i>triangle.length-1 || j>i){
            return Integer.MAX_VALUE;
        }
        if(i == triangle.length-1){
            return dp[i][j] = triangle[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int diagonalSum = triangle[i][j] + minimumPathSumMemoised(triangle, i+1, j+1, dp);
        int downSum = triangle[i][j] + minimumPathSumMemoised(triangle, i+1, j, dp);

        return dp[i][j] = Math.min(diagonalSum, downSum);
    }

    private static int minimumPathSumRecursive(int[][] triangle, int i, int j){

        if(i>triangle.length-1 || j>i){
            return Integer.MAX_VALUE;
        }
        if(i == triangle.length-1){
            return triangle[i][j];
        }

        int diagonalSum = minimumPathSumRecursive(triangle, i+1, j+1) + triangle[i][j];
        int downSum = minimumPathSumRecursive(triangle, i+1, j) + triangle[i][j];

        return Math.min(diagonalSum, downSum);
    }
}
