package org.dsa2023.dynamicprogramming.twoDimensionArray;

import java.util.Arrays;

public class MinSumPath {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(e->Arrays.fill(e,-1));
        System.out.println(minSumpath(arr, m - 1, n - 1,dp));
    }

    private static int minSumpath(int[][] arr, int i, int j,int[][] dp) {
        if (i == 0 && j == 0)
            return arr[0][0];
        if (i < 0 || j < 0)
            return 9999999;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int left = arr[i][j] + minSumpath(arr, i, j - 1,dp);
        int up = arr[i][j] + minSumpath(arr, i - 1, j,dp);
        return dp[i][j]=Math.min(left,up);
    }
}
