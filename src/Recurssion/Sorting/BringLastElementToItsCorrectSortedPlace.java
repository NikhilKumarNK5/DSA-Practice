package Recurssion.Sorting;

import java.util.Arrays;

public class BringLastElementToItsCorrectSortedPlace {
    public static void main(String[] args) {
        int[] ar = {3, 2, 6, 9, 7};
        rearrange(ar);
        System.out.println(Arrays.toString(ar));
    }

    static void rearrange(int[] ar) {
        int n = ar.length;
        int i = 0;
        int j = 0;
        int pivot = ar[n - 1];
        while(i <= n - 2) {
            if(ar[i] > pivot)
                i++;
            else {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j++;
            }
        }
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
