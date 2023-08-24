package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> subsetsList = new ArrayList<>();
        generateSubset(a, 0, new ArrayList<>(), subsetsList);
        subsetsList.forEach(System.out::println);
    }

    static void generateSubset(int[] a, int idx, List<Integer> list, List<List<Integer>> subsetList) {
        if (idx == a.length) {
            subsetList.add(new ArrayList<>(list));
            return;
        }

        //pick an element
        list.add(a[idx]);
        generateSubset(a, idx + 1, list, subsetList);

        //don't pick the element
        list.remove(list.size() - 1);
        generateSubset(a, idx + 1, list, subsetList);
    }
}
