package com.cspark.study.tryhelloworld;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by cspark on 2017. 3. 6..
 */
public class Level2Test {

    @Test
    public void callLevel2() {
        int []A = {1,2};
        int []B = {3,4};

        // 최솟값 만들기
        assertThat(getMinSum(A, B), is(10));

        // 2016년
        assertThat(getDayName(5, 24), is("TUE"));

        // 행렬의 곱셈
        int[][] a = { { 1, 2 }, { 2, 3 } };
        int[][] b = { { 3, 4 }, { 5, 6 } };
        assertThat(productMatrix(a, b), is(new int[][]{{13, 16}, {21, 26}}));

        // 하샤드수
        assertThat(isHarshad(18), is(true));

        // 정수 내림차순으로 배치하기
        assertThat(reverseInt(118372), is(873211));

        // 소수 찾기
        assertThat(numberOfPrime(10), is(4));

        // 콜라츠 추측
        assertThat(collatz(6), is(8));
        assertThat(collatz(1252663), is(-1));
    }

    /**
     * 최솟값 만들기
     *
     * @param A
     * @param B
     * @return
     */
    private int getMinSum(int []A, int []B) {
        int answer = 0;

        List<Integer> as = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        List<Integer> bs = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < as.size(); i++) {
            answer += (as.get(i) * bs.get(i));
        }

        return answer;
    }

    /**
     * 2016년
     *
     * @param month
     * @param date
     * @return
     */
    private String getDayName(int month, int date) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, month - 1 , date);

//        Calendar cal = new Calendar.Builder().setDate(2016, month - 1, date).build();
//        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase());

        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 행렬의 곱셈
     *
     * @param A
     * @param B
     * @return
     */
    private int[][] productMatrix(int[][] A, int[][] B) {
        int[][] answer = null;

        answer = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < B[j].length; k++) {
                    answer[i][k] += A[i][j] * B[j][k];
                }
            }
        }

        return answer;
    }


    /**
     * 하샤드수
     *
     * @param num
     * @return
     */
    private boolean isHarshad(int num){
        String strNum = String.valueOf(num);
        int sum = strNum.chars().map(x -> Integer.parseInt(String.valueOf((char) x))).sum();

        return num % sum == 0 ? true : false;
    }

    /**
     * 정수 내림차순으로 배치하기
     *
     * @param num
     * @return
     */
    private int reverseInt(int num){
        String[] strNums = String.valueOf(num).split("");
        String reverseStrNum =
                Arrays.stream(strNums)
                      .sorted(Collections.reverseOrder())
                      .collect(Collectors.joining());

        return Integer.parseInt(reverseStrNum);
    }


    /**
     * 소수 찾기
     *
     * @param num
     * @return
     */
    private int numberOfPrime(int num) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0)
                    break;

                if (j + 1 == primes.size())
                    primes.add(i);
            }
        }

        return primes.size();
    }


    /**
     * 콜라츠 추측
     *
     * @param num
     * @return
     */
    public int collatz(int num) {
        int answer = 0;
        long n = (long)num;

        while (n != 1) {
            n = (n % 2 == 0 ? n / 2 : n * 3 + 1);

            if (answer++ >= 500)
                return -1;

            System.out.println(answer + " : n = " + n);
        }

        return answer;

    }



}
