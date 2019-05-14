package com.bestbigbird;

import java.io.Serializable;


public class SourceTest implements Serializable {
    public int a = 3;
    public static Integer b = 6;
    public String s = "Hello World!";

    public final  Test test  =new Test();

    public static final String A_B_C = "qinwei";


    public void setA(String s){
        System.out.println(s);

    }

    public Test getTest(){
        return test;
    }

    public static   final String  say(){
        System.out.println(A_B_C);
        return A_B_C;
    }



}