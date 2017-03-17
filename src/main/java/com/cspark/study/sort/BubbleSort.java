package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 버블 정렬(Bubble Sort)
 * <p>
 * Created by cspark on 2017. 3. 14..
 */
public class BubbleSort {

    private void bubbleSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
            print(ints);
        }

        System.out.print("\nBubbleSort result : ");
        print(ints);
    }

    private void print(int[] ints) {
        System.out.println(
                Arrays.stream(ints)
                        .mapToObj(x -> String.valueOf(x))
                        .collect(Collectors.joining(","))
        );
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(new int[]{5, 4, 3, 2, 1});
    }
}
