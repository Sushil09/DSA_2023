package org.dsa2023.dynamicprogramming.single_dimension_array;

import java.util.Arrays;

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];

        //using Recursion - bottom up
//        System.out.println(maxNonAdjacentSum(arr, arr.length - 1, dp));

        //using top down - iteration
//        System.out.println(maxNonAdjacentSumTopDown(arr, dp));

        //Using space optimzed version
        System.out.println(maxNonAdjacentSumTopDownSpaceOptimized(arr));
    }

    private static int maxNonAdjacentSumTopDownSpaceOptimized(int[] arr) {
        int prev2 =0, prev1=arr[0],current=0;
        for (int i = 1; i < arr.length; i++) {
            int notPicked = ((i>=2)?prev2:0) + arr[i];
            current = Math.max(notPicked, prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }


    private static int maxNonAdjacentSumTopDown(int[] arr, int[] dp) {
        for (int i = 1; i < arr.length; i++) {
            int notPicked = ((i>=2)?dp[i - 2]:0) + arr[i];
            dp[i] = Math.max(notPicked, dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    static int maxNonAdjacentSum(int[] arr, int idx, int[] dp) {
        if (idx == 0)
            return arr[idx];
        if (idx < 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int pickCurrentElement = arr[idx] + maxNonAdjacentSum(arr, idx - 2, dp);
        int currentElementNotPicked = maxNonAdjacentSum(arr, idx - 1, dp);

        return dp[idx] = Math.max(pickCurrentElement, currentElementNotPicked);
    }

}
