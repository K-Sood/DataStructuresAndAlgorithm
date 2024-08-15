package main.java.dynammicProgramming;

/**
 * Question Link : https://www.naukri.com/code360/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
 */
public class GridUniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //return countPaths(m-1, n-1, m-1, n-1);
        // return countPathsMemoised(m-1, n-1, m-1, n-1, dp);
        dp[0][0] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else {
                    int up = 0;
                    int left = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];


    }

    private static int countPathsMemoised(int m, int n, int boundaryM, int boundaryN, int[][] dp){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n] != 0){
            return dp[m][n];
        }


        int pathCount1 = countPathsMemoised(m-1, n, boundaryM, boundaryN, dp) ;
        int pathCount2 = countPathsMemoised(m, n-1, boundaryM, boundaryN, dp) ;

        return dp[m][n] = pathCount1 + pathCount2;
    }

    private static int countPaths(int m, int n, int boundaryM, int boundaryN){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }

        int pathCount1 = countPaths(m-1, n, boundaryM, boundaryN) ;
        int pathCount2 = countPaths(m, n-1, boundaryM, boundaryN) ;

        return pathCount1 + pathCount2;
    }
}
