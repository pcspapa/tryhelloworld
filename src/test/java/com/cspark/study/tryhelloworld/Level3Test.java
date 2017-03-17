package com.cspark.study.tryhelloworld;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by cspark on 2017. 3. 7..
 */
public class Level3Test {

    @Test
    public void callLevel3() {
        // 다음 큰 숫자
        assertThat(nextBigNumber(78), is(83));
        assertThat(nextBigNumber2(78), is(83));

        // 멀리 뛰기
        assertThat(jumpCase(4), is(5));
        assertThat(jumpCase(5), is(8));
        assertThat(jumpCase2(4), is(5));
        assertThat(jumpCase2(5), is(8));

        // N개의 최소공배수
        assertThat(nlcm(new int[]{2, 6, 8, 14}), is(168L));
        assertThat(nlcm(new int[]{46, 8, 7, 77, 9, 73, 66, 38, 46, 69}), is(176859144L));

        // 야근 지수
        int []test = {4,3,3};
        assertThat(noOvertime(4, test), is(12));
    }

    /**
     * 다음 큰 숫자
     *
     * @param num
     * @return
     */
    private int nextBigNumber(int num) {
        int answer = num;
        int oneNextCnt = 0;
        String binaryStr = Integer.toBinaryString(num);
        String[] binaryStrs = binaryStr.split("");
        int oneCnt = Arrays.stream(binaryStrs).filter(s -> s.equals("1")).collect(Collectors.joining()).length();

        do {
            answer += 1;

            String binaryNextStr = Integer.toBinaryString(answer);
            String[] binaryNextStrs = binaryNextStr.split("");
            oneNextCnt = Arrays.stream(binaryNextStrs).filter(s -> s.equals("1")).collect(Collectors.joining()).length();

        } while (oneCnt != oneNextCnt);

        return answer;
    }

    /**
     * TODO 원리를 알아보자.
     * 다음 큰 숫자
     *
     * @param n
     * @return
     */
    private int nextBigNumber2(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;

        return n + postPattern | smallPattern;
    }

    /**
     * TODO 원리를 알아보자.
     * 멀리 뛰기
     *
     * @param num
     * @return
     */
    private int jumpCase(int num) {
        int answer = 0;
        int n1 = 1, n2 = 1;

        for (int i=1; i<num; i++) {
            answer = n1 + n2;
            n1 = n2;
            n2 = answer;
        }

        return answer;
    }

    /**
     * TODO 원리를 알아보자.
     * 멀리 뛰기
     *
     * @param num
     * @return
     */
    private int jumpCase2(int num) {
        int answer = 0;

        if (num <= 2) return num;
        answer = jumpCase(num-1) + jumpCase(num-2);

        return answer;
    }

    /**
     * N개의 최소공배수
     *
     * @param num
     * @return
     */
    private long nlcm(int[] num) {
        long answer = num[0];
        for (int i = 1; i < num.length; i++) {
            answer = answer * (long)num[i] / getGcd(answer, (long)num[i]);
        }

        return answer;
    }

    private long getGcd(long a, long b) {
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        long mod = max % min;

        while (mod > 0) {
            max = min;
            min = mod;
            mod = max % min;
        }

        return min;
    }


    /**
     * 야근 지수
     *
     * @param no
     * @param works
     * @return
     */
    private int noOvertime(int no, int[] works) {
        int result = 0;

        for (int i = 1; i <= no; i++) {
            Arrays.sort(works);
            if ( works[works.length -1] > 0)
                works[works.length -1] = works[works.length -1] - 1;
        }

        for (int work : works) {
            result += work * work;
        }


        return result;
    }

    /**
     * 야근 지수
     * TODO 원리를 알아보자.
     * @param no
     * @param works
     * @return
     */
    private int noOvertime2(int no, int[] works) {
        int result = 0, sum = 0, rest = 0, avg = 0, length = works.length;
        // 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?
        for(int work : works)
            sum += work;
        sum -= no;
        rest = sum%length;
        avg = sum/length;
        result = (length-rest)*avg*avg + rest*(avg+1)*(avg+1);
        return result;
    }
}
