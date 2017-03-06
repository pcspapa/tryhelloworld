package com.cspark.study.tryhelloworld;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by cspark on 2017. 3. 4..
 */
public class Level1Test {

    @Test
    public void callLevel1() {
        // 평균값 구하기
        assertThat(getMean(null), is(0));
        assertThat(getMean(new int[]{0, 0, 0}), is(0));
        assertThat(getMean(new int[]{5, 4, 3}), is(4));

        // 최대값과 최소값
        assertThat(getMinMaxString(null), is(""));
        assertThat(getMinMaxString("0 0 0 0"), is("0 0"));
        assertThat(getMinMaxString("1 2 3 4"), is("1 4"));
        assertThat(getMinMaxString("4 3 2 1"), is("1 4"));

        // 짝수와 홀수
        assertThat(evenOrOdd(0), is("Even"));
        assertThat(evenOrOdd(1), is("Odd"));
        assertThat(evenOrOdd(2), is("Even"));
        assertThat(evenOrOdd(3), is("Odd"));
        assertThat(evenOrOdd(4), is("Even"));

        // 스트링을 숫자로 바꾸기
        assertThat(getStrToInt(null), is(0));
        assertThat(getStrToInt("-1234"), is(-1234));

        // 수박수박수박수박수박수?
        assertThat(watermelon(0), is(""));
        assertThat(watermelon(3), is("수박수"));
        assertThat(watermelon(4), is("수박수박"));

        //서울에서 김서방 찾기
        assertThat(findKim(new String[]{"Queen", "Tod","Kim"}), is("김서방은 2에 있다"));

        // 삼각형출력하기
        assertThat(printTriangle(3), is("*\n**\n***\n"));

        // 문자열 내림차순으로 배치하기
        assertThat(reverseStr("Zbcdefg"), is("gfedcbZ"));

        // 나누어 떨어지는 숫자 배열
        assertThat(divisible(new int[]{5, 9, 7, 10}, 5), is(new int[]{5, 10}));

        // 가운데 글자 가져오기
        assertThat(getMiddle("power"), is("w"));
        assertThat(getMiddle("test"), is("es"));

        // 최대공약수와 최소공배수
        assertThat(gcdlcm(3, 12), is(new int[]{3, 12}));
        assertThat(gcdlcm(12, 3), is(new int[]{3, 12}));

        // 행렬의 덧셈
        assertThat(sumMatrix(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}}), is(new int[][]{{4, 6}, {7, 9}}));
        assertThat(sumMatrix(new int[][]{{1, 1, 1}, {1, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 1}}), is(new int[][]{{2, 2, 2,}, {2, 2, 2}}));

        // 피보나치 수
        assertThat(fibonacci(3), is(2L));

        // 약수의 합
        assertThat(sumDivisor(12), is(28));
    }


    /**
     * 평균값 구하기
     *
     * @param array
     * @return
     */
    private int getMean(int[] array) {
        if (array == null)
            return 0;

        return (int) Arrays.stream(array).average().getAsDouble();
    }

    /**
     * 최대값과 최소값
     *
     * @param str
     * @return
     */
    private String getMinMaxString(String str) {
        if (str == null)
            return "";

        String[] arr = str.split(" ");
        int minInt = Arrays.stream(arr).mapToInt(x -> Integer.parseInt(x)).min().getAsInt();
        int maxInt = Arrays.stream(arr).mapToInt(x -> Integer.parseInt(x)).max().getAsInt();

        return minInt + " " + maxInt;
    }

    /**
     * 짝수와 홀수
     *
     * @param num
     * @return
     */
    private String evenOrOdd(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }


    /**
     * 스트링을 숫자로 바꾸기
     *
     * @param str
     * @return
     */
    private int getStrToInt(String str) {
        if (str == null)
            return 0;

        return Integer.parseInt(str);
    }

    /**
     * 수박수박수박수박수박수?
     * return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
     *
     * @param n
     * @return
     */
    private String watermelon(int n){
        String[] patten = {"수", "박"};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append( patten[i % 2]);
        }

        return sb.toString();
    }

    /**
     * 서울에서 김서방 찾기
     *
     * @param seoul
     * @return
     */
    private String findKim(String[] seoul){
        int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+ x + "에 있다";
    }

    /**
     * 삼각형출력하기
     *
     * @param num
     * @return
     */
    private String printTriangle(int num){
        StringBuffer result = new StringBuffer();
        StringBuffer star = new StringBuffer("*");

        for (int i = 0 ; i < num ; i++) {
            result.append(star);
            result.append("\n");

            star.append("*");
        }

        return result.toString();
    }

    /**
     * 문자열 내림차순으로 배치하기
     *
     * StringBuffer, StringBuilder, StringJoiner 을 알아보자.
     * @param str
     * @return
     */
    private String reverseStr(String str){
        StringBuffer sb = new StringBuffer();

        str.chars().sorted().forEach(x -> sb.append(String.valueOf((char) x)));
//        str.chars().sorted().forEach(x -> sb.append(Character.toString((char) x)));  // OK

        return sb.reverse().toString();
    }

    /**
     * 나누어 떨어지는 숫자 배열
     *
     * @param array
     * @param divisor
     * @return
     */
    private int[] divisible(int[] array, int divisor) {
        return Arrays.stream(array).filter(i -> (i % divisor == 0)).toArray();
    }

    /**
     * 가운데 글자 가져오기
     *
     * @param word
     * @return
     */
    private String getMiddle(String word){
        char[] chars = word.toCharArray();

        return chars.length % 2 == 0 ? String.valueOf(chars[chars.length / 2 -1 ]) + String.valueOf(chars[chars.length / 2]) : String.valueOf(chars[chars.length / 2])  ;
    }

    /**
     * 최대공약수와 최소공배수
     *
     * @param a
     * @param b
     * @return
     */
    private int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int mod =  1;

        while (mod > 0) {
            mod = max % min;
            max = min;
            min = mod;
        }

        answer[0] = max;
        answer[1] = (a * b) / max;

        return answer;
    }

    /**
     * 행렬의 덧셈
     *
     * @param A
     * @param B
     * @return
     */
    private int[][] sumMatrix(int[][] A, int[][] B) {
        int[][] answer = {{0, 0}, {0, 0}};

        if (A.length != B.length)
            return answer;

        for (int i = 0; i < A.length; i++) {
            if (A[i].length != B[i].length)
                return answer;
        }

        answer = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                answer[i][j] = A[i][j] + B[i][j];
            }
        }

        return answer;
    }

    /**
     * 피보나치 수
     *
     * @param num
     * @return
     */
    public long fibonacci(int num) {
        long answer = 0;

        if (num == 0 || num == 1)
            return num;

        long[] vals = {0, 1};
        for (int i = 2; i <= num; i++) {
            answer = vals[0] + vals[1];

            vals[0] = vals[1];
            vals[1] = answer;
        }

        return answer;
    }

    /**
     * 약수의 합
     *
     * @param num
     * @return
     */
    public int sumDivisor(int num) {
        int answer = 0;

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                divisors.add(i);
        }

        return divisors.stream().mapToInt(x -> x).sum();
    }

}
