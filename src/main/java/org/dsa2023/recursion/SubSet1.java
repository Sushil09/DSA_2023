package org.dsa2023.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSet1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = subsetSums(new ArrayList<>(Arrays.asList(1,2,3)),3);
        System.out.println(list);
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> subsetSumList = new ArrayList<>();
        subsetSum(arr,0,0,subsetSumList);
        return subsetSumList;
    }

    static void subsetSum(ArrayList<Integer> arr, int idx, int sum,ArrayList<Integer> sumList){
        if(idx==arr.size()){
            sumList.add(sum);
            return;
        }

        sum+=arr.get(idx);
        subsetSum(arr,idx+1,sum,sumList);

        sum-=arr.get(idx);
        subsetSum(arr,idx+1,sum,sumList);
    }
}
