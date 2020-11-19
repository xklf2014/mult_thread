package com.story.multthread.t02;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T07_exception {
    int count = 0;

    synchronized void t() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T07_exception t=  new T07_exception();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.t();
            }
        };

        new Thread(r,"t").start();
    }
}
