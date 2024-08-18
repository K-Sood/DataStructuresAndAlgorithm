package main.java.dynammicProgramming;


/**
 * // cherry pickup, chocolate pickup, ninja and his friends.
 * QuestionLink : https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
 */
public class ChocolatePickup {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // return (int) maximumChocolatesRecursive(r, c, grid, 0, 0, c-1);
        long[][][] dp = new long[r][c][c];

        // return (int) maximumChocolatesMemoised(r, c, grid, 0, 0, c-1, dp);

        for (int i = r-1; i>=0; i--){
            for(int aliceJ = 0; aliceJ<c; aliceJ++){
                for(int bobJ=0; bobJ<c; bobJ++){
                    if(i == r-1){
                        if(aliceJ == bobJ)
                            dp[i][aliceJ][bobJ] = grid[i][aliceJ];
                        else
                            dp[i][aliceJ][bobJ] = grid[i][aliceJ] + grid[i][bobJ];
                    }
                    else{
                        long maxVal = Integer.MIN_VALUE;
                        for(int offsetAliceJ = -1; offsetAliceJ<=1; offsetAliceJ++){
                            for(int offsetBobJ = -1; offsetBobJ<=1; offsetBobJ++){
                                int value = 0;
                                int tempAliceJ = aliceJ + offsetAliceJ;
                                int tempBobJ = bobJ + offsetBobJ;
                                if(aliceJ == bobJ)
                                    value = grid[i][aliceJ];
                                else
                                    value = grid[i][aliceJ] + grid[i][bobJ];

                                if(tempAliceJ<0 || tempAliceJ>=c || tempBobJ<0 || tempBobJ>=c)
                                    maxVal = Math.max(maxVal, Integer.MIN_VALUE);
                                else
                                    maxVal = Math.max(maxVal, dp[i+1][tempAliceJ][tempBobJ] + value);
                            }
                        }
                        dp[i][aliceJ][bobJ] = maxVal;
                    }



                }
            }


        }

        return (int)dp[0][0][c-1];
    }

    public static long maximumChocolatesMemoised(int r, int c, int[][] grid, int i, int jAlice, int jBob, long[][][] dp){

        if(jAlice<0 || jAlice>=c || jBob<0 || jBob>=c){
            return Integer.MIN_VALUE;
        }

        if(i == r-1){
            if(jAlice == jBob){
                return dp[i][jAlice][jBob] = grid[i][jBob];
            }else{
                return dp[i][jAlice][jBob] = grid[i][jAlice] + grid[i][jBob];
            }

        }
        if(dp[i][jAlice][jBob] != 0){
            return dp[i][jAlice][jBob];
        }

        long maxPathSum = Integer.MIN_VALUE;
        for(int jAliceTemp = -1; jAliceTemp<=1; jAliceTemp++){
            for(int jBobTemp = -1; jBobTemp<=1; jBobTemp++){
                int jAliceEffective = jAlice + jAliceTemp;
                int jBobEffective = jBob + jBobTemp;
                if(jAlice == jBob){
                    maxPathSum = Math.max(maxPathSum,
                            maximumChocolatesMemoised(r, c, grid, i+1, jAliceEffective, jBobEffective, dp) + grid[i][jAlice]);
                }else{
                    maxPathSum = Math.max(maxPathSum,
                            maximumChocolatesMemoised(r, c, grid, i+1, jAliceEffective, jBobEffective, dp) + grid[i][jAlice] + grid[i][jBob]);
                }


            }
        }

        return dp[i][jAlice][jBob] = maxPathSum;


    }

    public static long maximumChocolatesRecursive(int r, int c, int[][] grid, int i, int jAlice, int jBob){

        if(jAlice<0 || jAlice>=c || jBob<0 || jBob>=c){
            return Integer.MIN_VALUE;
        }

        if(i == r-1){
            if(jAlice == jBob){
                return grid[i][jBob];
            }else{
                return grid[i][jAlice] + grid[i][jBob];
            }

        }
        long maxPathSum = Integer.MIN_VALUE;
        for(int jAliceTemp = -1; jAliceTemp<=1; jAliceTemp++){
            for(int jBobTemp = -1; jBobTemp<=1; jBobTemp++){
                int jAliceEffective = jAlice + jAliceTemp;
                int jBobEffective = jBob + jBobTemp;
                if(jAlice == jBob){
                    maxPathSum = Math.max(maxPathSum,
                            maximumChocolatesRecursive(r, c, grid, i+1, jAliceEffective, jBobEffective) + grid[i][jAlice]);
                }else{
                    maxPathSum = Math.max(maxPathSum,
                            maximumChocolatesRecursive(r, c, grid, i+1, jAliceEffective, jBobEffective) + grid[i][jAlice] + grid[i][jBob]);
                }


            }
        }

        return maxPathSum;
    }
}
