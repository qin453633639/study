package com.bestbigbird.classloader;


import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {

       /* myClassLoader();
        System.out.println(1);
        aaa();*/

       bb();

    }
    public static void bb(){
        ClassLoader a  = ClassLoader.getSystemClassLoader();
        System.out.println("--------"+a);
        URL[] extURLs = ((URLClassLoader)a).getURLs();
        for (int i = 0; i < extURLs.length; i++) {
            System.out.println(extURLs[i]);
        }

        System.out.println("--------"+a.getParent());
        extURLs = ((URLClassLoader)a.getParent()).getURLs();
        for (int i = 0; i < extURLs.length; i++) {
            System.out.println(extURLs[i]);
        }

        System.out.println("--------"+a.getParent().getParent());
        extURLs = ((URLClassLoader)a.getParent().getParent()).getURLs();
        for (int i = 0; i < extURLs.length; i++) {
            System.out.println(extURLs[i]);
        }
    }

    public static void aaa()throws Exception{
        String root = "D:\\idea\\project\\study\\java\\agent\\target\\classes";
        String c = "com.intrumentation.Demo";

        String root1 = "D:\\idea\\project\\study\\java\\base\\target\\classes";
        String c1 = "com.bestbigbird.classloader.MyClass";
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot(root1);
        Class<?>  testClass = classLoader.loadClass(c1);
        System.out.println(testClass.getClassLoader());

        MyClassLoaderTwo classLoader2 = new MyClassLoaderTwo();
        classLoader2.setRoot(root1);
        Class<?>  testClass2 = classLoader2.loadClass(c1);
        System.out.println(testClass2.getClassLoader());




    }

    public static void  myClassLoader() throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("D:\\idea\\project\\study\\java\\base\\target\\classes");
        Class<?>  testClass = classLoader.loadClass("D:\\idea\\project\\study\\java\\base\\target\\classes");
        Object object = testClass.newInstance();
        ClassLoader a = object.getClass().getClassLoader();
        while (a != null) {
            System.out.println(a);
            a = a.getParent();
        }
        while (true){
            Thread.sleep(1000);
            System.out.println(1);
        }
    }

    public static void content(){
        /*System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));*/
    }
}
