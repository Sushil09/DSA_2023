package org.dsa2023.dynamicprogramming.twoDimensionArray;

import java.util.Arrays;

public class ZeroOneKnapSack {
    public static void main(String[] args) {
        int N = 3, W = 4;
        int[]values = {1,2,3};
        int[]weights = {4,5,1};
        int[][]dp=new int[N][W+1];
        Arrays.stream(dp).forEach(e->Arrays.fill(e,-1));

        //Filling first row with 0
        Arrays.fill(dp[0],0);
        //Filling first column with 0
        for(int i=0;i<N;i++)
            dp[i][0]=0;

        if(weights[0]<W)
            dp[0][weights[0]]=values[0];

//        System.out.println(maxProfits(values,weights,N-1,W,dp));

        System.out.println(maxProfitsBottomUp(values,weights,N,W,dp));
    }


    private static int maxProfits(int[] arr, int[] wt, int idx, int W,int[][]dp) {
        if(idx<0 || W<0)
            return 0;
        if(idx==0 && wt[idx]<=W)
            return arr[idx];
        if(dp[idx][W]!=-1)
            return dp[idx][W];

        int picked = Integer.MIN_VALUE;
        if(wt[idx]<=W)
            picked=arr[idx]+maxProfits(arr,wt,idx-1,W-wt[idx],dp);
        int notPicked=maxProfits(arr,wt,idx-1,W,dp);

        return dp[idx][W]=Math.max(picked,notPicked);
    }

    private static int maxProfitsBottomUp(int[] arr, int[] wt, int N, int W,int[][]dp) {

        for(int i=1;i<N;i++){
            for(int j=1;j<=W;j++){
                int picked= Integer.MIN_VALUE;
                if(j>wt[i])
                    picked=arr[i]+dp[i-1][j-wt[i]];
                int notPicked=dp[i-1][j];

                dp[i][j]=Math.max(picked,notPicked);
            }
        }
        return dp[N-1][W];
    }

}
