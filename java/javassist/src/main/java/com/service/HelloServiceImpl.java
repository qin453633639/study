package com.service;

/**
 * Created by qinwei on 2018/11/12.
 */
public class HelloServiceImpl implements HelloService {

    public  void print(String name){
        System.out.println(name);
    }
    public  String getAddress(){
        return "Hunan";
    }
}
