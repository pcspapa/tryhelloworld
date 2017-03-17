package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 선택 정렬(Selection Sort)
 * 선택 정렬은 이름에 맞게 현재 위치에 들어갈 값을 찾아 정렬하는 배열이다.
 * 현재 위치에 저장 될 값의 크기가 작냐, 크냐에 따라 최소 선택 정렬와 최대 선택 정렬로 구분 할 수 있다.
 * 1. 정렬 되지 않은 인덱스의 맨 앞에서 부터 이를 포함한 그 이후의 배열값 중 가장 작은 값을 찾아간다.
 * 2. 가장 작은 값을 찾으면, 그 값을 현재 인덱스의 값과 바꿔준다.
 * 3. 다음 인덱스에서 위 과정을 반복해준다.
 *
 * Created by cspark on 2017. 3. 14..
 */
public class SelectionSort {

    private void selectionSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int min = ints[i];
            int aux = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                    aux = j;
                }
            }
            ints[aux] = ints[i];
            ints[i] = min;

            print(ints);
        }

        System.out.print("\nSelectionSort result : ");
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
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(new int[]{5, 4, 3, 2, 1});
    }

}
