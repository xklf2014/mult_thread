package com.story.multthread.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class T04_NotifyFreeLock {

    volatile List lists = new ArrayList();

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    public static void main(String[] args) {
        T04_NotifyFreeLock t = new T04_NotifyFreeLock();

        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock){
                System.out.println("t2启动");
                if (t.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 over");
                lock.notify();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add"+i);

                    if (t.size() == 5){
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
    }
}
