package com.cspark.study.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 삽입 정렬(Insertion Sort)
 * 삽입 정렬은 현재 위치에서 그 이전의 배열들을 비교하여 자신이 들어갈 위치를 찾아 그 위치에 삽입하는 배열이다.
 * 1. 삽입 정렬은 두 번째 인텍스부터 시작한다. 현재 인텍스는 별도의 변수에 저장해주고, 비교 인텍스는 현재 인덱스 -1로 잡는다.
 * 2. 별도로 저장해 둔 삽입을 위한 변수와 비교 인텍스의 배열 값을 비교한다.
 * 3. 삽입 변수의 값이 더 작으면 현재 인덱스로 비교 인덱스의 값을 저장해주고, 비교 인덱스를 -1하여 비교 반복한다.
 * 4. 만약 삽입 변수가 더 크면, 비교 인덱스 _1에 삽입 변수를 저장한다.
 *
 * Created by cspark on 2017. 3. 14..
 */
public class InsertionSort {

    private void insertionSort(int[] ints) {

        for (int i = 1; i < ints.length; i++) {
            int standard = ints[i];
            int aux = i - 1;
            while (aux >= 0 && standard < ints[aux]) {
                ints[aux + 1] = ints[aux];

                aux--;
            }
            ints[aux + 1] = standard;

            print(ints);
        }

        System.out.print("\nInsertionSort result : ");
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
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(new int[]{5, 4, 3, 2, 1});


    }
}
