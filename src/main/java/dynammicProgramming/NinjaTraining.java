package main.java.dynammicProgramming;

public class NinjaTraining {

    public static int ninjaTraining(int n, int points[][]) {

        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);


        // return taskMax(n-1, points, 3);
        // return taskMaxMemoization(n-1, points, 3, dp);
        //return Math.max(Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]),dp[n-1][3]);

        int[][] dpTabulated = new int[n][4];
        dpTabulated[0][0] = Math.max(points[0][1], points[0][2]);
        dpTabulated[0][1] = Math.max(points[0][0], points[0][2]);
        dpTabulated[0][2] = Math.max(points[0][0], points[0][1]);
        dpTabulated[0][3] = Math.max(points[0][2], Math.max(points[0][0], points[0][1]));
        for(int day=1; day<n; day++){
            for(int task=0; task<=3; task++){
                dpTabulated[day][task] = Integer.MIN_VALUE;
                for(int i=0; i<=2; i++){
                    if(i!=task)
                        dpTabulated[day][task] = Math.max(dpTabulated[day][task],
                                dpTabulated[day-1][i] + points[day][i]);
                }


            }
        }

        return dpTabulated[n-1][3];

    }

    private static int taskMaxMemoization(int n, int[][] points, int lastTask, int[][] dp){

        if(dp[n][lastTask] != 0 ){
            return dp[n][lastTask];
        }

        int maxScore = Integer.MIN_VALUE;
        for(int i=0; i<=2; i++){
            if(i != lastTask){
                maxScore = Math.max(taskMaxMemoization(n-1, points, i, dp) + points[n][i], maxScore);
            }
        }

        dp[n][lastTask] = maxScore;
        return maxScore;

    }

    private static int taskMax(int n, int[][] points, int lastTask){

        if(n == 0){
            if(lastTask == 0){
                return Math.max(points[0][1], points[0][2]);
            }
            if(lastTask == 1){
                return Math.max(points[0][0], points[0][2]);
            }
            if(lastTask == 2){
                return Math.max(points[0][0], points[0][1]);
            }

        }
        int maxScore = Integer.MIN_VALUE;

        for(int i=0; i<=2; i++){
            if(i != lastTask){
                maxScore = Math.max(taskMax(n-1, points, i) + points[n][i], maxScore);

            }
        }

        return maxScore;
    }
}
