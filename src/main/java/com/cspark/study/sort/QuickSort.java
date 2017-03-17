package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 쿽 정렬은 분할 정복을 이용하여 정렬을 수행하는 알고리즘이다.
 * pivot point이라는 기준이 되는 값을 하나 설정 하는데, 이 값을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 옮기는 방식으로 정렬을 진행하다.
 * 이를 반복하여 분할된 배열의 크기가 1이 되면 배열이 모두 정렬된 것이다.
 * Created by cspark on 2017. 3. 17..
 */
public class QuickSort {


    private void quickSort(int[] ints, int lp, int rp) {
        int li = lp;
        int ri = rp;
        int pivot = ints[(lp + rp) / 2];

        do {
            while (ints[li] < pivot) li++;
            while (ints[ri] > pivot) ri--;

            if (li <= ri) {
                int aux =  ints[li];
                ints[li] = ints[ri];
                ints[ri] = aux;

                li++;
                ri--;
            }
        } while (li <= ri);

        print(ints);


        if (lp < ri) quickSort(ints, lp, ri);
        if (rp > li) quickSort(ints, li, rp);
    }

    private void print(int[] ints) {
        System.out.println(
                Arrays.stream(ints)
                        .mapToObj(x -> String.valueOf(x))
                        .collect(Collectors.joining(","))
        );
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = {5, 6, 1, 4, 7, 2, 3};
        quickSort.quickSort(ints, 0, 6);

        System.out.print("\nquickSort result : ");
        quickSort.print(ints);
    }
}
