package main.java.dynammicProgramming;


/**
 * Question Link: https://www.naukri.com/code360/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
 */
public class MaximumPathSumFreeFalling {

    public static int getMaxPathSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;

        // for(int i=0; i<matrix[0].length; i++){
        // 	int[][] dp = new int[matrix.length][matrix[0].length];
        // 	// maxSum = Math.max(maxSum, getMaxPathSumMemoization(matrix, 0, i, dp));

        // }

        // tabulation
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }

        for(int i=matrix.length-1; i>=0; i--){
            for(int j =0; j<matrix[0].length; j++){
                if(i == matrix.length-1){
                    dp[i][j] = matrix[i][j];
                }else {
                    int down = dp[i+1][j] + matrix[i][j];
                    int downLeft = Integer.MIN_VALUE;
                    int downRight = Integer.MIN_VALUE;
                    if(j>0){
                        downLeft = dp[i+1][j-1] + + matrix[i][j];
                    }
                    if(j<matrix[0].length-1){
                        downRight = dp[i+1][j+1] + + matrix[i][j];
                    }

                    dp[i][j] = Math.max(down, Math.max(downLeft, downRight));
                }
            }
        }


        for(int j =0; j<matrix[0].length; j++){
            maxSum= Math.max(maxSum, dp[0][j]);
        }


        return maxSum;
    }

    private static int getMaxPathSumMemoization(int[][] matrix, int i, int j, int[][] dp) {

        if(j>matrix[0].length-1 || j<0){
            return (int)Math.pow(10,7)*-1;
        }
        if(i == matrix.length-1){
            return dp[i][j] = matrix[i][j];
        }
        if(dp[i][j]!= 0){
            return dp[i][j];
        }


        int down = getMaxPathSumRecursion(matrix, i+1, j) + matrix[i][j];
        int downLeft = getMaxPathSumRecursion(matrix, i+1, j-1) + matrix[i][j];
        int downRight = getMaxPathSumRecursion(matrix, i+1, j+1) + matrix[i][j];

        return dp[i][j] = Math.max(down, Math.max(downLeft, downRight));

    }


    private static int getMaxPathSumRecursion(int[][] matrix, int i, int j) {

        if(j>matrix[0].length-1 || j<0){
            return (int)Math.pow(10,7)*-1;
        }
        if(i == matrix.length-1){
            return matrix[i][j];
        }


        int down = getMaxPathSumRecursion(matrix, i+1, j) + matrix[i][j];
        int downLeft = getMaxPathSumRecursion(matrix, i+1, j-1) + matrix[i][j];
        int downRight = getMaxPathSumRecursion(matrix, i+1, j+1) + matrix[i][j];

        return Math.max(down, Math.max(downLeft, downRight));

    }
}
