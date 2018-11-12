package com.bestbigbird;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * Created by qinwei on 2018/9/20.
 */
public class JavassistMain {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //会从classpath中查询该类
        CtClass cc = pool.get("test.Rectangle");
        //设置.Rectangle的父类
        cc.setSuperclass(pool.get("test.Point"));
        //输出.Rectangle.class文件到该目录中
        //cc.writeFile("c://");
        //输出成二进制格式
        byte[] b=cc.toBytecode();
        //输出并加载class 类，默认加载到当前线程的ClassLoader中，也可以选择输出的ClassLoader。
        Class clazz=cc.toClass();
    }
}
