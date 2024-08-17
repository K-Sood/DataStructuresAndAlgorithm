package main.java.dynammicProgramming;

import java.util.ArrayList;

public class UniquePathWithObstacles {
    static int mod = (int)(1e9+7);
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // return mazeObstaclesHelperRecursive(n-1, m-1, n, m, mat);

        int[][] dp = new int[n][m];

        // return mazeObstaclesHelperMemoized(n-1, m-1, n, m, mat, dp);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(mat.get(i).get(j) == -1){
                    dp[i][j] = 0;
                }else if (i == 0 && j==0){
                    dp[0][0] = 1;
                }
                else{

                    int leftCount = 0;
                    int upCount = 0;

                    if(i>0 )
                        upCount = dp[i-1][j];

                    if(j>0)
                        leftCount = dp[i][j-1];

                    dp[i][j] = (upCount + leftCount)%mod;
                }
            }
        }

        return dp[n-1][m-1];
    }


    private static int mazeObstaclesHelperMemoized(int currN, int currM, int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if(currN<0 || currM<0) {
            return 0;
        }
        if(mat.get(currN).get(currM) == -1){
            return 0;
        }
        if(currN==0 && currM==0) {
            return dp[0][0] = 1;
        }
        if(dp[currN][currM] != 0){
            return dp[currN][currM];
        }


        int leftPathCount = mazeObstaclesHelperMemoized(currN, currM-1, n, m, mat, dp);
        int upPathCount = mazeObstaclesHelperMemoized(currN-1, currM, n, m, mat, dp);

        return dp[currN][currM] = (leftPathCount + upPathCount)%mod;

    }


    private static int mazeObstaclesHelperRecursive(int currN, int currM, int n, int m, ArrayList<ArrayList<Integer>> mat){

        if(currN<0 || currM<0) {
            return 0;
        }
        if(mat.get(currN).get(currM) == -1){
            return 0;
        }
        if(currN==0 && currM==0) {
            return 1;
        }


        int leftPathCount = mazeObstaclesHelperRecursive(currN, currM-1, n, m, mat);
        int upPathCount = mazeObstaclesHelperRecursive(currN-1, currM, n, m, mat);

        return leftPathCount + upPathCount;



    }

}


