package com.bestbigbird.yinyong;

import java.lang.ref.*;
import java.util.HashSet;
import java.util.Set;

class User {

    private String name;

    public User()
    {}

    public User(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void finalize(){
        System.out.println("Finalizing ... "+name);
    }
}

/**
 * Created by jinxu on 15-4-25.
 */
public class ReferenceDemo {

    private static ReferenceQueue<User> referenceQueue = new ReferenceQueue<User>();
    private static final int size = 10;

    public static void checkQueue(){
       /* Reference<? extends User> reference = null;
        while((reference = referenceQueue.poll())!=null){
            System.out.println("In queue : "+reference.get());
        }*/
        Reference<? extends User> reference = null;
        while ( (reference = referenceQueue.poll()) != null){
            System.out.println("In queue : "+reference  + "    "+"data "+reference.get());
        }

    }

    public static void checkSet(Set<? extends  Reference<User>> set){
        System.out.println("遍历set：");
        for(Reference<User> reference :set){
            System.out.println("reference "+reference + "   data "+reference.get());
        }
    }

    public static void testSoftReference()
    {
        Set<SoftReference<User>> softReferenceSet = new HashSet<SoftReference<User>>();
        for (int i = 0; i < size; i++) {
            SoftReference<User> ref = new SoftReference<User>(new User("Soft " + i), referenceQueue);
            softReferenceSet.add(ref);
        }
        System.gc();
        checkQueue();
    }

    public static void testWeaKReference() throws InterruptedException {
        Set<WeakReference<User>> weakReferenceSet = new HashSet<WeakReference<User>>();
        for (int i = 0; i < size; i++) {
            WeakReference<User> ref = new WeakReference<User>(new User("Weak " + i), referenceQueue);
            weakReferenceSet.add(ref);
        }
        checkSet(weakReferenceSet);
        System.out.println("垃圾回收。。。。。。");
        System.gc();
        Thread.sleep(10000);
        checkQueue();
    }

    public static void testPhantomReference() throws InterruptedException {
        Set<PhantomReference<User>> phantomReferenceSet = new HashSet<PhantomReference<User>>();
        for (int i = 0; i < size; i++) {
            PhantomReference<User> ref =
                    new PhantomReference<User>(new User("Phantom " + i), referenceQueue);
            System.out.println("Just created: " + ref.get());
            phantomReferenceSet.add(ref);
        }
        System.gc();
        checkQueue();
    }

    public static void main(String[] args) throws InterruptedException {
       /* testSoftReference();*/
        testWeaKReference();

         /*testPhantomReference();*/

    }
}