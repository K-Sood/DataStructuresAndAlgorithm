package main.java.dynammicProgramming;


import java.util.Arrays;

/**
 * question Link : https://atcoder.jp/contests/dp/tasks/dp_b
 * video link : https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5
 */
public class FrogJumpWithKOptions {

    public static void main(String[] args) {

//        5 3
//        10 30 40 50 20
        System.out.println("Recursive : " + frogKJump(4, new int[]{10, 30, 40, 50, 20}, 3));
        int[] dp1 = new int[5];
        Arrays.fill(dp1, -1);
        System.out.println("Memoized : " + frogKJumpMemoized(4, new int[]{10, 30, 40, 50, 20}, 3, dp1));
        System.out.println("Tabulated : " + frogKJumpTabulated(5, new int[]{10, 30, 40, 50, 20}, 3));

//        3 1
//        10 20 10
        System.out.println("Recursive : " + frogKJump(2, new int[]{10, 20, 10}, 1));
        int[] dp2 = new int[3];
        Arrays.fill(dp2, -1);
        System.out.println("Memoized : " + frogKJumpMemoized(2, new int[]{10, 20, 10}, 1, dp2));
        System.out.println("Tabulated : " + frogKJumpTabulated(3, new int[]{10, 20, 10}, 1));

//        2 100
//        10 10
        System.out.println("Recursive : " + frogKJump(1, new int[]{10, 10}, 100));
        int[] dp3 = new int[2];
        Arrays.fill(dp3, -1);
        System.out.println("Memoized : " + frogKJumpMemoized(1, new int[]{10, 10}, 100, dp3));
        System.out.println("Tabulated : " + frogKJumpTabulated(2, new int[]{10, 10}, 100));

//        10 4
//        40 10 20 70 80 10 20 70 80 60
        System.out.println("Recursive : " + frogKJump(9, new int[]{40, 10, 20, 70, 80, 10, 20, 70, 80, 60}, 4));
        int[] dp4 = new int[10];
        Arrays.fill(dp4, -1);
        System.out.println("Memoized : " + frogKJumpMemoized(9, new int[]{40, 10, 20, 70, 80, 10, 20, 70, 80, 60}, 4, dp4));
        System.out.println("Tabulated : " + frogKJumpTabulated(10, new int[]{40, 10, 20, 70, 80, 10, 20, 70, 80, 60}, 4));


    }

    private static int frogKJump(int n, int[] heights, int k) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(heights[1] - heights[0]);
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (n - i >= 0)
                minEnergy = Math.min(minEnergy, frogKJump(n - i, heights, k) + Math.abs(heights[n] - heights[n - i]));
        }

        return minEnergy;

    }


    private static int frogKJumpMemoized(int n, int[] heights, int k, int[] dp) {

        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(heights[1] - heights[0]);
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (n - i >= 0)
                minEnergy = Math.min(minEnergy, frogKJump(n - i, heights, k) + Math.abs(heights[n] - heights[n - i]));
        }
        dp[n] = minEnergy;
        return minEnergy;

    }

    private static int frogKJumpTabulated(int n, int[] heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0)
                    minEnergy = Math.min(minEnergy, dp[i - j] + Math.abs(heights[i] - heights[i - j]));
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

}
