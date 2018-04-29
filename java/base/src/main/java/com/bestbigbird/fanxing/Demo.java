package com.bestbigbird.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwei on 2018/4/24.
 */
public class Demo<T> {
    List<String> a1;//这里返回的是，ArrayList，Class类型
    List<ArrayList<String>> a2;//这里返回的是ArrayList<String>，ParameterizedType类型
    List<T> a3;//返回的是T，TypeVariable类型
    List<? extends Number> a4; //返回的是WildcardType类型
    List<? super String> a5; //返回的是WildcardType类型
    List<ArrayList<String>[]> a6;//GenericArrayType


}
