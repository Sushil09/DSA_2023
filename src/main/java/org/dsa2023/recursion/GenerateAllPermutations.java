package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllPermutations {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> permuteList = new ArrayList<>();
//        boolean[] visited = new boolean[a.length];
//        generateAllPerutationsWithFlagTest(a, new ArrayList<>(), permuteList, visited);
        generateALlPermutations(a,0,permuteList);
        permuteList.forEach(System.out::println);

    }

    private static void generateAllPerutationsWithFlagTest(int[] arr, ArrayList<Integer> list, List<List<Integer>> permuteList, boolean[] visited) {
        if (list.size() == arr.length) {
            permuteList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                generateAllPerutationsWithFlagTest(arr, list, permuteList, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    static void generateALlPermutations(int[] arr, int idx, List<List<Integer>> permuteList) {
        if (idx == arr.length) {
            List<Integer> list = new ArrayList<>();
            for(int x:arr)
                list.add(x);
            permuteList.add(list);
            return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(idx,i,arr);
            generateALlPermutations(arr,idx+1,permuteList);
            swap(idx,i,arr);
        }
    }

    private static void swap(int i, int j, int[]a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
