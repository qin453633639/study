package com.bestbigbird.current.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args){

        Student s1 = new Student(1);
        Student s2 = new Student(2);
        AtomicReference<Student> ar = new AtomicReference<>(s1);
        ar.compareAndSet(s1, s2);
        Student s3 = ar.get();

        System.out.println("s3 is " + s3);  // 2
        System.out.println("s3.equals(s1) = " + s3.equals(s1)); // false
    }
}

   class Student {
    volatile long id;
    public Student(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "student id = "+id;
    }
}