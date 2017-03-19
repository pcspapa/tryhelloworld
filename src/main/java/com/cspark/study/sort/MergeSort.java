package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 합병 정렬(Merge Sort)
 *
 * 합병 정렬은 정복 방식으로 설계된 알고리즘이다.
 * 분할 정복은 큰 문제를 반으로 쪼개 문제를 해결해나가는 방식으로 분할은 배열의 크기가 1보다 작거나 같을 때 까지 반복한다.
 * 입력으로 하나의 배열을 받고 연산 중에 두개의 배열로 계속 쪼게 나간 뒤, 합치면서 정렬해 최후에는 하나의 정렬이 출력한다.
 *
 * Created by cspark on 2017. 3. 14..
 */
public class MergeSort {


    private void mergeSort(int[] ints, int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            mergeSort(ints, s, m);
            mergeSort(ints, m + 1, e);
            merge(ints, s, m , e);
        }

        System.out.print("\nMergeSort result : ");
        print(ints);
    }

    private void merge(int[] ints, int s, int m, int e) {
        int[] ret = new int[ints.length];
        int li = s;
        int ri = m + 1;
        int ci = s;

        while (li <= m && ri <= e) {
            if (ints[li] < ints[ri])
                ret[ci] = ints[li++];
            else
                ret[ci] = ints[ri++];

            ci++;
        }

        while(li <= m) ret[ci++] = ints[li++];
        while(ri <= e) ret[ci++] = ints[ri++];

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != 0)
                ints[i] = ret[i];
        }
    }

    private void print(int[] ints) {
        System.out.println(
                Arrays.stream(ints)
                        .mapToObj(x -> String.valueOf(x))
                        .collect(Collectors.joining(","))
        );
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(new int[]{3, 2, 1, 6, 5, 4}, 0, 5);
    }
}
