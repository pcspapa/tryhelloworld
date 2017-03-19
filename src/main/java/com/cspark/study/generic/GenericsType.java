package com.cspark.study.generic;

/**
 * Created by cspark on 2017. 3. 18..
 */
public class GenericsType<T> {

    private T t;

    public T get(){
        return this.t;
    }

    public void set(T t1){
        this.t=t1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GenericsType{");
        sb.append("t=").append(t);
        sb.append('}');
        return sb.toString();
    }

    /**
     * result
     *   - type1 : GenericsType{t=cspark}
     *   - type2 : GenericsType{t=10}
     *
     * @param args
     */
    public static void main(String args[]){
        GenericsType<String> type1 = new GenericsType<>();
        type1.set("cspark"); //valid
        System.out.println("type1 : " + type1);

        GenericsType type2 = new GenericsType(); //raw type2
        type2.set("cspark"); //valid
        type2.set(10); //valid and autoboxing support
        System.out.println("type2 : " + type2);
    }

}
