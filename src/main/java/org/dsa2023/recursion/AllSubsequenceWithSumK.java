package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int K = 2;
        printAllSubsequenceWithSumK(arr, 0, K, 0, new ArrayList<>());
    }

    private static void printAllSubsequenceWithSumK(int[] arr, int idx, int sum, int tempSum, List<Integer> list) {
        if (idx == arr.length) {
            if (sum == tempSum) {
                list.forEach(System.out::print);
                System.out.println();
            }
            return;
        }

        //take the current idx element
        tempSum += arr[idx];
        list.add(arr[idx]);
        printAllSubsequenceWithSumK(arr, idx + 1, sum, tempSum, list);

        //skip the current idx element
        tempSum -= arr[idx];
        list.remove(list.size() - 1);
        printAllSubsequenceWithSumK(arr, idx + 1, sum, tempSum, list);

    }
}
