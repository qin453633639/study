package com.bestbigbird.annotation.parse;

import com.bestbigbird.annotation.MyDatabaseClassAnnotation;
import com.bestbigbird.annotation.MyMethodAnnotation;
import com.bestbigbird.annotation.MyTablebaseClassAnnotation;


/**
 * Created by qinwei on 2018/2/12.
 */

@MyDatabaseClassAnnotation(database = "gearbest")
public class MyDatabase {

    @MyTablebaseClassAnnotation(table = "user")
    public String table;

    @MyMethodAnnotation(method="methodhaa")
    public void get(){

    }
}
