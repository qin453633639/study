package com.bestbigbird.annotation.parse;

import org.springframework.stereotype.Service;
import spring.annotation.MyDatabaseClassAnnotation;
import spring.annotation.MyMethodAnnotation;
import spring.annotation.MyTablebaseClassAnnotation;

/**
 * Created by qinwei on 2018/2/12.
 */
@Service
@MyDatabaseClassAnnotation(database = "gearbest")
public class MyDatabase {

    @MyTablebaseClassAnnotation(table = "user")
    public String table;

    @MyMethodAnnotation(method="methodhaa")
    public void get(){

    }
}
