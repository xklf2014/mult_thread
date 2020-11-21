package com.story.multthread.t03;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T06_FineCoarseLock {
    int count = 0;

    synchronized void t1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void t2() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println(count);
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T06_FineCoarseLock t = new T06_FineCoarseLock();

/*        long start = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.t1();
            }
        }).start();
        long over = System.currentTimeMillis();
        System.out.println("共耗时:" + (over - start));

        System.out.println("-----------------");*/

        long begin = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.t2();
            }
        }).start();
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - begin));



    }
}
