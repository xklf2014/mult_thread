package com.story.multthread.t06;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class T05_CountDownLatch {
    volatile List lists = new ArrayList();

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    public static void main(String[] args) {
        T05_CountDownLatch t = new T05_CountDownLatch();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("t2启动");
            if (t.size() != 5){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 over");
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add"+i);

                if (t.size() == 5){
                    latch.countDown();
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
