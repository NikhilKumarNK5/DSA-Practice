package Recurssion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 1, 8, 7};
        int target = 1;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchEnd(arr, target, arr.length - 1));
        System.out.println(linearSearch2(arr, target, 0));
        returnAllIndices(arr, target, 0);
        System.out.println(list);
        System.out.println(findAllIndices(arr, target, 0, new ArrayList<>()));
        System.out.println(findIndices(arr, target, 0));
    }

    // find index from start
    static int linearSearch(int[] arr, int target, int index) {
        if(index == arr.length)
            return -1;
        if(arr[index] == target)
            return index;
        return linearSearch(arr, target, index + 1);
    }

    // find index from end
    static int linearSearchEnd(int[] arr, int target, int index) {
        if(index == -1)
            return -1;
        if(arr[index] == target)
            return index;
        return linearSearchEnd(arr, target, index - 1);
    }

    //need boolean if we are just checking if the element exists or not and we do not need the index
    static boolean linearSearch2(int[] arr, int target, int index) {
        if(index == arr.length)
            return false;
        return arr[index] == target || linearSearch2(arr, target, index + 1);
    }

    // find all indices
    static ArrayList<Integer> list = new ArrayList<>();
    static void returnAllIndices(int[] arr, int target, int index) {
        if(index == arr.length) {
            return;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        returnAllIndices(arr, target, index + 1);
    }

    // returning an ArrayList by passing into as an argument
    static ArrayList<Integer> findAllIndices(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length)
            return list;
        if(arr[index] == target)
            list.add(index);
        return findAllIndices(arr, target, index + 1, list);
    }

    // returning an ArrayList without passing an argument
    static ArrayList<Integer> findIndices(int[] arr, int target, int index) {
        // at every function call a new ArrayList will be created
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length)
            return list;
        // this will contain answer for that function call only
        if(arr[index] == target)
            list.add(index);
        ArrayList<Integer> ansFromBelowCalls = findIndices(arr, target, index + 1);
        list.addAll(ansFromBelowCalls); // adding all the answers we have till now adding that to the list
        return list;
    }
}
