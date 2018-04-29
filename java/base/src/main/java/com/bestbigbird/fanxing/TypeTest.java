package com.bestbigbird.fanxing;

import java.lang.reflect.*;
import java.util.List;

class HaveGenericClass<T>{}
class NoGenericClass{}

public class TypeTest<T> {
    private List<String> list;
    private T t;
    private List list1;
    private List<T> list2;
    private HaveGenericClass haveGenericClassWithoutGeneric;
    private HaveGenericClass<String> haveGenericClassWithGeneric;
    private NoGenericClass noGenericClass;
    private int var;
    private List<T>[] listTArr;
    private List<String>[] listStringArr;
    private List[] listArr;
    private T[] tArr;
    private int[] intArr;
    private HaveGenericClass[] haveGenericClassWithoutGenericArr;
    private HaveGenericClass<T>[] haveGenericClassWithGenericArr;
    private HaveGenericClass<String>[] haveGenericClassWithGenericArr2;
    private NoGenericClass[] noGenericClassArr;
    private <U> U genericMethod(U u,String s){
        return u;
    }
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
        Field[] fields = TypeTest.class.getDeclaredFields();
        for( Field f: fields ){
            Type t = f.getGenericType();
            printType(f.getName(), t);
        }
        Method genericMethod = TypeTest.class.getDeclaredMethod("genericMethod",Object.class,String.class);
        Type[] types = genericMethod.getGenericParameterTypes();

    }
    public static void printType(String name, Type type){
        if( type instanceof Class ){
            System.out.println("the type of " + name + " is : Class");
        }else if( type instanceof ParameterizedType ){
            System.out.println("the type of " + name + " is : ParameterizedType");
        }else if( type instanceof GenericArrayType ){
            System.out.println("the type of " + name + " is : GenericArrayType");
        }else if( type instanceof TypeVariable ){
            System.out.println("the type of " + name + " is : TypeVariable");
        }
    }
}
