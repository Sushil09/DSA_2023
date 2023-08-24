package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceGeneration {
    public static void main(String[] args) {
        int [] numbers = {1,2,3};
        generateSubsequence(numbers,0,new ArrayList<>());
    }

    static void generateSubsequence(int[] arr, int idx, List<Integer> list){
        if(idx>=arr.length){
            list.forEach(System.out::print);
            System.out.println();
            return;
        }

        //pick the element
        list.add(arr[idx]);
        generateSubsequence(arr,idx+1,list);

        //don't pick the element
        list.remove(list.size()-1);
        generateSubsequence(arr,idx+1,list);
    }
}
