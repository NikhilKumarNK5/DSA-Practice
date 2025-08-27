package Recurssion.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 5, 12};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length == 1)
            return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                merged[k++] = first[i++];
            } else {
                merged[k++] = second[j++];
            }
        }

        // it may be possible one of the arrays is not complete - so copy all the remaining elements
        while(i < first.length) {
            merged[k++] = first[i++];
        }

        while(j < second.length) {
            merged[k++] = second[j++];
        }

        return merged;
    }

    static void mergeSortInPlace(int[] arr, int start, int end) {
        if(end - start == 1)
            return;

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j < end) {
            if(arr[i] < arr[j])
                merged[k++] = arr[i++];
            else
                merged[k++] = arr[j++];
        }

        while(i < mid)
            merged[k++] = arr[i++];

        while(j < end)
            merged[k++] = arr[j++];

        for(int l = 0; l < merged.length; l++) {
            arr[start + l] = merged[l];
        }
    }
}
