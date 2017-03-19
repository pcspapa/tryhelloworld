package com.cspark.study;

/**
 * Created by cspark on 2017. 3. 19..
 */
public class Combination {

    private static void combinationUtil(int arr[], int n, int r, int index, int data[], int target) {
        if (index == r) {
//            for (int j = 0; j < r; j++)
//                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        if (target >= n)
            return;

        System.out.println(index + ", " + target);
        data[index] = arr[target];
        combinationUtil(arr, n, r, index + 1, data, target + 1);
        combinationUtil(arr, n, r, index, data, target + 1);
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        combinationUtil(arr, n, r, 0, new int[r], 0);
    }

}
