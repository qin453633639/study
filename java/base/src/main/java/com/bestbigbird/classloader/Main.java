package com.bestbigbird.classloader;


public class Main {
    public static void main(String[] args) throws Exception {

        //myClassLoader();
        aaa();

    }

    public static void aaa()throws Exception{
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("F:\\idea\\source\\agent\\target\\classes");
        Class<?>  testClass = classLoader.loadClass("com.intrumentation.Demo");
        System.out.println(testClass.getClassLoader());

        MyClassLoaderTwo classLoader2 = new MyClassLoaderTwo();
        classLoader2.setRoot("F:\\idea\\source\\agent\\target\\classes");
        Class<?>  testClass2 = classLoader2.loadClass("com.intrumentation.Demo");
        System.out.println(testClass2.getClassLoader());




    }

    public static void  myClassLoader() throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("F:\\idea\\source\\agent\\target\\classes");
        Class<?>  testClass = classLoader.loadClass("com.intrumentation.Demo");
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
