package org.dsa2023.dynamicprogramming.twoDimensionArray;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));

//        System.out.println(uniquePaths(m-1,n-1,dp));
        System.out.println(topDownCountWays(m, n));
    }

    //Bottom up
    static int uniquePaths(int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int upwards = uniquePaths(i - 1, j, dp);
        int left = uniquePaths(i, j - 1, dp);

        return dp[i][j] = upwards + left;

    }

    static int topDownCountWays(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int upward=0,left=0;
                    if(i>=1)
                        upward=dp[i - 1][j];
                    if(j>=1)
                        left=dp[i][j - 1];
                    dp[i][j]=left+upward;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
