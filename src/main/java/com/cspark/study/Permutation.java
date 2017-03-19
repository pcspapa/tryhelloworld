package com.cspark.study;

/**
 * 순열
 *
 * Created by cspark on 2017. 3. 6..
 */
public class Permutation {

    public static void perm(int[] arr, int pivot) {
        if (pivot == arr.length) {
            print(arr);
            return;
        }

        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1);
            swap(arr, i, pivot);
        }
    }

    public static void perm(int[] arr, int pivot, int n) {
        if (pivot == n) {
            print(arr, n);
            return;
        }

        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1, n);
            swap(arr, i, pivot);
        }

    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void print(int[] arr) {
        print(arr, arr.length);
    }

    public static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                System.out.println(arr[i]);
            else
                System.out.print(arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("Length : ");
        perm(arr, 0);

        System.out.println("Limit : ");
        perm(arr, 0, 3);
    }


}
