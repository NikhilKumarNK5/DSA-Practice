package Recurssion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 1, 8, 7};
        int target = 1;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchEnd(arr, target, arr.length - 1));
        System.out.println(linearSearch2(arr, target, 0));
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
}
