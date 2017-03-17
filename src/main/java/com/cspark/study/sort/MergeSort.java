package com.cspark.study.sort;

/**
 * Created by cspark on 2017. 3. 14..
 */
public class MergeSort {


    private void mergeSort(int[] ints) {
        int length = ints.length;

        if (length > 1) {
            int[] left = new int[length / 2];
            int[] right = new int[length - (length / 2)];

            for (int i = 0; i < ints.length; i++) {
                if (i < length / 2)
                    left[i] = ints[i];
                else
                    right[i - (length / 2)] = ints[i];
            }

            mergeSort(left);
            mergeSort(right);
            merge(ints, left, right);
        }

    }

    private void merge(int[] ints, int[] left, int[] right) {

    }


    public static void main(String[] args) {

    }
}
