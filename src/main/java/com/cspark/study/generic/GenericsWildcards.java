package com.cspark.study.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cspark on 2017. 3. 18..
 */
public class GenericsWildcards {

    public static double sum1(List<Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    // Java Generics Upper Bounded Wildcard
    public static double sum2(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    // Java Generics Unbounded Wildcard
    public static void printData(List<?> list){
        for(Object obj : list){
            System.out.print(obj + "::");
        }
    }

    // Java Generics Lower bounded Wildcard
    public static void addIntegers(List<? super Integer> list){
        list.add(new Integer(50));
    }

    public static void main(String[] args) {
        List<Number> ints1 = Arrays.asList(3, 5, 10);
        List<Integer> ints2 = Arrays.asList(3, 5, 10);

        double sum1_1 = sum1(ints1);
        // double sum1_2 = sum1(ints2);  // error
        System.out.println("Sum1_1 of ints = " + sum1_1);

        double sum2_1 = sum2(ints1);
        double sum2_2 = sum2(ints2);
        System.out.println("Sum2_1 of ints = " + sum2_1);
        System.out.println("Sum2_2 of ints = " + sum2_2);


    }
}
