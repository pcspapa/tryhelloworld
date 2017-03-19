package com.cspark.study.generic;

/**
 * Created by cspark on 2017. 3. 18..
 */
public class GenericsMethods {

    // Java Generic Method
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
        return g1.get().equals(g2.get());
    }

    // Java Generics Bounded Type Parameters
    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }

    public static void main(String args[]){
        GenericsType<String> type1 = new GenericsType<>();
        type1.set("cspark");

        GenericsType<String> type2 = new GenericsType<>();
        type2.set("cspark");


        boolean isEqual = GenericsMethods.<String>isEqual(type1, type2);
        System.out.println("1. isEqual : " + isEqual);
        // above statement can be written simply as
        isEqual = GenericsMethods.isEqual(type1, type2);
        System.out.println("2. isEqual : " + isEqual);
        // This feature, known as type1 inference, allows you to invoke a generic method as an ordinary method, without specifying a type1 between angle brackets.
        // Compiler will infer the type1 that is needed

        int compare = compare("String", "CSPARK");
        System.out.println("compare : " + compare);
    }
}
