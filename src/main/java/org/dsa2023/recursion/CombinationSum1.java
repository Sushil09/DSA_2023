package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        int K =7;
        List<List<Integer>> combinedSum = combinationSum(arr, K);
        combinedSum.forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> numbersList = new ArrayList<>();

        targetSum(candidates, 0, target, new ArrayList<>(), 0, numbersList);

        return numbersList;

    }

    static void targetSum(int[] arr, int idx, int K, List<Integer> list, int tempSum, List<List<Integer>> answerList) {
        if (idx >= arr.length || tempSum > K)
            return;
        if (tempSum == K) {
            answerList.add(new ArrayList<>(list));
            return;
        }

        tempSum += arr[idx];
        list.add(arr[idx]);
        targetSum(arr, idx, K, list, tempSum, answerList);

        tempSum -= arr[idx];
        list.remove(list.size() - 1);
        targetSum(arr, idx + 1, K, list, tempSum, answerList);

    }
}
