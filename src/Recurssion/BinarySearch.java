package Recurssion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 2;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] < target)
            return binarySearch(arr, target, mid + 1, end);
        return binarySearch(arr, target, start, mid - 1);
    }
}
