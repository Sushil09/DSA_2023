package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsetWithoutDuplicate(nums,0,new ArrayList<>(), subsetList);
        return subsetList;
    }

    static void generateSubsetWithoutDuplicate(int[] arr,int idx, List<Integer> list, List<List<Integer>> subsetList){
        subsetList.add(new ArrayList<>(list));
        // if(idx==arr.length){

        //     return;
        // }

        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1]) continue;

            list.add(arr[i]);
            generateSubsetWithoutDuplicate(arr,i+1, list,subsetList);
            list.remove(list.size()-1);
        }

    }
}
