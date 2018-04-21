package com.bestbigbird.current.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<User> mAtoLong = AtomicIntegerFieldUpdater.newUpdater(User.class, "id");
        User person = new User(123456);
        mAtoLong.compareAndSet(person, 123456, 1000);
        System.out.println("id=" + person.toString()); //1000
        mAtoLong.getAndAdd(person,10);
    }
}

class User {
    volatile int id;

    public User(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "student id = " + id;
    }
}