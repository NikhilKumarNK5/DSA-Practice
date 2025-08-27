package Recurssion.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low >= high)
            return;

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while(start <= end) {
            // also a reason why if it's already sorted won't swap
            while(arr[start] < pivot)
                start++;
            while(arr[end] > pivot)
                end--;

            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}

