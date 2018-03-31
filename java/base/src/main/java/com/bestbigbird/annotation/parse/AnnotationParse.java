package com.bestbigbird.annotation.parse;

import com.bestbigbird.annotation.MyDatabaseClassAnnotation;
import com.bestbigbird.annotation.MyMethodAnnotation;
import com.bestbigbird.annotation.MyTablebaseClassAnnotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by qinwei on 2018/2/12.
 */
public class AnnotationParse {
    public static void main(String[] args) {
        Class myTable  = MyDatabase.class;
        Annotation[] annotations = myTable.getAnnotations();
        for (Annotation item:annotations){

           if(item instanceof MyDatabaseClassAnnotation ){
               MyDatabaseClassAnnotation a  = (MyDatabaseClassAnnotation)item;
               System.out.println(a.database());
           }
        }

        Method[] methods = myTable.getMethods();
        for(Method method :methods){
            Annotation[] methodAnnotations = method.getAnnotations();
            for(Annotation item:methodAnnotations){
                if(item instanceof MyMethodAnnotation){
                    MyMethodAnnotation a = (MyMethodAnnotation)item;
                    System.out.println(a.method());
                }
            }
        }

        Field[] fields = myTable.getFields();

        for(Field field:fields){
            Annotation[] fieldAnnotations = field.getAnnotations();
            for(Annotation item:fieldAnnotations){
                if(item instanceof MyTablebaseClassAnnotation){
                    System.out.println(((MyTablebaseClassAnnotation) item).table());
                }
            }
        }
    }
}
