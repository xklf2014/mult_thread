package com.story.multthread.t06;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class T06_LockSupport {
    volatile List lists = new ArrayList();

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    public static void main(String[] args) {
        T06_LockSupport t = new T06_LockSupport();

        Thread t2 = new Thread(()->{
            System.out.println("t2启动");
            if (t.size() != 5){
                LockSupport.park();
            }
            System.out.println("t2 over");
        },"t2");

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add"+i);

                if (t.size() == 5){
                    LockSupport.unpark(t2);
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
    }
}
