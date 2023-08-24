package org.dsa2023.dynamicprogramming.single_dimension_array;

import java.util.Arrays;

public class FibonacciNumberGeneration {
    public static void main(String[] args) {
        //Given n, calculate F(n).
        int n = 5;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1); //Initially setting all values to -1
        int resultFromTopDown = fibonacciTopDownApproach(n, arr);
        int resultFromBottomUp = fibonacciBottomUpApproach(n, arr);
        int resultWithoutExtraSpace = fibonacciWithoutExtraSpace(n);
//        System.out.println(resultFromTopDown);
//        System.out.println(resultFromBottomUp);
        System.out.println(resultWithoutExtraSpace);
    }

    static int fibonacciTopDownApproach(int n, int[] arr) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (arr[n] != -1)
            return arr[n];
        return arr[n] = fibonacciTopDownApproach(n - 1, arr) + fibonacciTopDownApproach(n - 2, arr);
    }

    static int fibonacciBottomUpApproach(int n, int[] arr) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    static int fibonacciWithoutExtraSpace(int n) {
        int prev1 = 0;
        int prev2 = 1;
        int current =prev1+prev2;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }
}
