package main.java.dynammicProgramming;


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem Statement: https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 * Solution Video : https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6
 */
public class MaximumNonAdjacentSum {

    public static void main(String[] args) {

//        int[] dp = new int[nums.size()];
//        Arrays.fill(dp, -1);
        return maximumNonAdjacentSumHelperTabulated(Stream.of(5, 6, 6).collect(Collectors.toCollection()));
        // return maximumNonAdjacentSumHelperMemoised(nums.size()-1, nums, dp);

    }

    private static int maximumNonAdjacentSumRecursion(int i, ArrayList<Integer> nums){
        if(i == 0){
            return nums.get(0);
        }
        if(i<0){
            return 0;
        }

        int pickSum = nums.get(i) + maximumNonAdjacentSumRecursion(i-2, nums);
        int notPickSum = maximumNonAdjacentSumRecursion(i-1, nums);


        return Math.max(pickSum, notPickSum);

    }

    private static Integer maximumNonAdjacentSumHelperMemoised(int i, ArrayList<Integer> nums, int[] dp){

        if(i<0){
            return 0;
        }
        if(i == 0){
            return nums.get(0);
        }
        if(dp[i] != -1){
            return dp[i];
        }


        int pickSum = nums.get(i) + maximumNonAdjacentSumHelperMemoised(i-2, nums, dp);
        int notPickSum = maximumNonAdjacentSumHelperMemoised(i-1, nums, dp);
        dp[i] = Math.max(pickSum, notPickSum );

        return dp[i];

    }

    private static Integer maximumNonAdjacentSumHelperTabulated(ArrayList<Integer> nums){
        // Index starting 0

        // if(nums.size() == 1){
        // 	return nums.get(0);
        // }
        // if(nums.size() == 2){
        // 	return Math.max(nums.get(0), nums.get(1));
        // }

        // int[] dp = new int[nums.size()];
        // dp[0] = nums.get(0);
        // dp[1] = Math.max(nums.get(0), nums.get(1));
        // for(int i= 2; i<dp.length; i++){

        // 	dp[i] = Math.max(nums.get(i) + dp[i-2], dp[i-1]);
        // }

        // return dp[dp.length - 1];

        int[] dp = new int[nums.size()+1];
        dp[0] = 0;
        dp[1] = nums.get(0);
        // dp[1] = Math.max(nums.get(0), nums.get(1));
        for(int i= 2; i<dp.length; i++){

            dp[i] = Math.max(nums.get(i-1) + dp[i-2], dp[i-1]);
        }

        return dp[dp.length - 1];

    }


}
