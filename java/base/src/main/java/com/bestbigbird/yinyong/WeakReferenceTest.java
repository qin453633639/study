package com.bestbigbird.yinyong;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static boolean details = false; //是否打印详细解释


    public static void testCommon() {
        A a = new A();
        B b = new B(a);
        System.out.println(a);
        System.out.println(b.B_a);


        a = null;
        //b=null;
        if (details) {
            //强引用未调用gc时
            System.out.println("============强引用未调用gc时======================");
            System.out.println("指向a的引用已经取消：" + a); //此处A的引用被取消
            System.out.println("B中引用到A对象a的引用仍然存在：" + b.B_a);//引用仍然存在
            System.out.println(b.B_a.getName() + ":B中指向a的引用，仍然有对象存在。可以访问方法getName()");//引用指向的对象a仍然存在(对象存在堆中，虽然栈中的引用不再指向它，但该对象在gc回收的时候，是不会被回收的，造成了内存泄漏)
        }


        try {

            Thread.sleep(100);
            System.gc();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (details) {
            System.out.println("============强引用调用gc后======================");
            System.out.println("指向a的引用已经取消：" + a); //此处A的引用被取消
            System.out.println("B中引用到A对象a的引用仍然存在：" + b.B_a);//引用仍然存在
        }

        System.out
                .println(b.B_a.getName() + ":B中指向a的引用，仍然有对象存在。可以访问方法getName()。对象存在堆中，虽然栈中A的引用不再指向它，但该B中的强引用B_a强引用仍然指向它，所以对象在gc回收的时候，是不会被回收的，造成了内存泄漏"
                );//引用指向的对象a仍然存在(对象存在堆中，虽然栈中的引用不再指向它，但该对象在gc回收的时候，是不会被回收的，造成了内存泄漏)

        b = null;//将B的引用指向空，此时再调gc垃圾回收，只会回收B的对象b,会将B_a指向置为空，但不会清理B_a指向的堆中的对象

        //如何验证？

    }


    public static void testWeakRef() {
        A a = new A();
        WeakReference<A> weakA = new WeakReference<A>(a);
        B b = new B(weakA);
        System.out.println(a);
        System.out.println(weakA);
        System.out.println(b.weak_a);


        a = null;
        //b = null;
        if (details) {
            System.out.println("---===========弱引用未调用gc时候===================----");
            System.out.println(a);
            System.out.println(b.weak_a);
            System.out.println(b.weak_a.get() + ":B中通过弱引用指向A对象a,引用指向的对象可以找到："); //未调用垃圾回收
        }
        try {
            Thread.sleep(100);
            System.gc();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /**
         * JDK6关于WeakReference的get方法的解释
         * get
         * public T get()
         * 返回此引用对象的指示对象。如果此引用对象已经由程序或垃圾回收器清除，则此方法将返回 null。
         * 返回：
         * 此引用所引用的对象；如果此引用对象已经清除，则返回 null。
         *
         */
        if (details) {
            System.out.println("---===========弱引用调用gc之后===================----");
            System.out.println("A对象指向a的引用已经不存在：" + a);//a的引用也被取消
            System.out.println("B中通过弱引用指向A对象a,引用仍然存在：" + b.weak_a); // 引用仍然存在
        }
        System.out.println(b.weak_a.get()
                        + ":A的引用a指向对象在堆中已经找不到了.A的引用不再指向a，B中通过弱引用指向A对象a,此时gc回收的时候，发现没有强引用它，" +
                "只有弱引用指向它，仍然会回收堆中的对象。此时weak_a引用仍然存在，而且指向堆中的地址，" +
                "但是该地址中已经没有对象存在了，所以不会出现A中的对象a,变成堆中遗留下的不可控对象，这样就防止了内存泄漏："); //引用指向对象在堆中已经找不到了,所以不会A中的对象a,不再是堆中遗留下的不可控对象，防止了内存泄漏

//        b = null;
        //此时，b指向a的weak_a，由于已经不存在了。gc之后，不会在堆中产生不可控对象a。提前已经回收掉了。
    }


    public static void main(String[] args) {
        details = true;//如果想要查看详细步骤，请放开该行代码
        /*testCommon();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();*/
        testWeakRef();
    }
}


class A {
    private String name = "class-A";


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}


class B {
    public A B_a;


    public WeakReference<A> weak_a;


    private String name = "class-B";


    public B(WeakReference<A> a) {
        weak_a = a;


    }


    public B(A a) {
        B_a = a;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}