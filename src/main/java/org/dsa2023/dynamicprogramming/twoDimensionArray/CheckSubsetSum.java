package org.dsa2023.dynamicprogramming.twoDimensionArray;

import java.util.Arrays;

public class CheckSubsetSum {
    public static void main(String[] args) {
        int[] arr ={3, 34, 4, 12, 5, 2};
        int K = 30;
//        System.out.println(checkSubsetSum(arr, K, arr.length - 1));
        System.out.println(checkSubsetSumTabulation(arr,K));
    }

    private static boolean checkSubsetSum(int[] arr, int sum, int idx) {
        if (sum == 0)
            return true;
        if (idx == 0)
            return arr[idx] == sum;

        boolean doNotTake = checkSubsetSum(arr, sum, idx - 1);
        boolean take = false;
        if (sum >= arr[idx])
            take = checkSubsetSum(arr, sum - arr[idx], idx - 1);
        return take || doNotTake;

    }

    private static boolean checkSubsetSumTabulation(int[]arr, int K){
        int M = arr.length;
        int N= K;
        boolean[][]dp=new boolean[M][N+1];
        for(int i=0;i<M;i++)
            dp[i][0]=true;
        if(arr[0]<=K)
            dp[0][arr[0]]=true;
        for (int i=1;i<M;i++){
            for (int j=1;j<=N;j++){
                boolean included = false;
                boolean excluded=false;
                if(j>=arr[i])
                    included=dp[i-1][j] || dp[i-1][j-arr[i]];
                else
                    excluded=dp[i-1][j];
                dp[i][j]=included||excluded;
            }
        }
        return dp[M-1][N];
    }
}
