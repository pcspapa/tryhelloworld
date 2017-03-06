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
    }

    /**
     * 최솟값 만들기
     *
     * @param A
     * @param B
     * @return
     */
    public int getMinSum(int []A, int []B) {
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
    public String getDayName(int month, int date) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, month - 1 , date);

//        Calendar cal = new Calendar.Builder().setDate(2016, month - 1, date).build();
//        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase());

        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

}
