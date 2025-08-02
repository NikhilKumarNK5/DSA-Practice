package Recurssion;

public class FindIfAnArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9, 12};
        System.out.println(sortedOrNot(arr));

        int[] arr2 = {1, 4, 3, 5, 7, 8};
        System.out.println(sortedOrNot(arr2));

        if(sorted(arr2, 0)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Unsorted");
        }
    }

    static String sortedOrNot(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return "Unsorted";
        }
        return "Sorted";
    }

    // using recursion
    static boolean sorted(int[] arr, int index) {
        // base condition
        if(index == arr.length - 1)
            return true;
        return arr[index] < arr[index + 1] && sorted(arr, index + 1);
    }
}
