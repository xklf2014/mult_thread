package com.story.multthread.t03;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T07_SyncSameObject {

    Object o = new Object();

    void t() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T07_SyncSameObject t = new T07_SyncSameObject();

        new Thread(t::t,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::t,"t2");

        //锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会
        //t.o = new Object();

        t2.start();
    }
}
