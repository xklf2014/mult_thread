package com.story.multthread.t02;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T01_testSynchronized {

    private int count = 10;
    private Object o = new Object();
    private static int c = 10;

    public void test() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    public void test1() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    public synchronized void test2() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public static synchronized void test3() {
        c--;
        System.out.println(Thread.currentThread().getName() + " count:" + c);
    }

    public static void test4(){
        synchronized (T01_testSynchronized.class){
            c--;
            System.out.println(Thread.currentThread().getName() + " count:" + c);
        }
    }

    public static void main(String[] args) {
        T01_testSynchronized t = new T01_testSynchronized();

  /*      new Thread(()->{
            while (t.count>0){
                t.test();
            }
        }).start();*/

    /*    new Thread(()->{
            while (t.count>0){
                t.test1();
            }
        }).start();*/
/*
        new Thread(() -> {
            while (t.count > 0) {
                t.test2();
            }
        }, "syncThread").start();*/

        /*new Thread(()->{
            while (c>0){
                test3();
            }
        },"staticThread").start();*/
/*
        while (t.count>0){
            t.test();
        }*/

        new Thread(()->{
            while (c>0){
                test4();
            }
        },"lockClass").start();

    }
}
