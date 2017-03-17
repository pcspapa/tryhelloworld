package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 버블 정렬(Bubble Sort)
 *
 * 버블 정렬은 매번 연속된 두개 인덱스를 비교하여 정한 기준의 값을 뒤로 넘겨 정렬하는 방법이다. 오
 * 름차순으로 정렬하고자 할 경우 큰 값을 뒤로 이동 1바퀴 돌면 가장 큰 값이 맨 뒤에 저장.
 *
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
