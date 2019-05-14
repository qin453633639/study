package com.bestbigbird.integer;

/**
 * Created by qinwei on 2019/3/18.
 */
public class IntegerTest {
    public static void main(String[] args) {
       Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);

        System.out.println(c == 200);

        System.out.println(200 == c);

    }

    public static void aa(Object a ,Object b){
        Object tmp =a;
        a = b;
        b = tmp;

    }




}
